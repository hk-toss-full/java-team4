package game;

import info.Pet;
import info.User;
import mainController.MainController;
import mainController.MainService;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Typing extends Thread {
    static User user = User.getInstance();
    Pet pet = Pet.getInstance2();
    static int coin = user.getCoin();
    private static MainService mainService = MainService.getInstance();
    private static MainController mainController = MainController.getInstance();
//    AtomicBoolean gameEnded = new AtomicBoolean(false);
    public static void typing() {
        AtomicBoolean gameEnded = new AtomicBoolean(false);
        String[] quiz = {
                "군인은 현역을 면한 후가 아니면 국무위원으로 임명될 수 없다.",
                "고용, 임금 및 근로조건에 있어서 부당한 차별을 받지 아니한다.",
                "헌법재판소의 조직과 운영 기타 필요한 사항은 법률로 정한다.",
                "추가경정예산안을 편성하여 국회에 제출할 수 있다.",
                "자격, 감사대상공무원의 범위 기타 필요한 사항은 법률로 정한다.",
                "국회의 집회가 불가능한 때에 한하여 법률의 효력을 가지는 명령을 발할 수 있다.",
                "국회의원과 정부는 법률안을 제출할 수 있다.",
                "모든 국민은 법률이 정하는 바에 의하여 납세의 의무를 진다.",
                "대통령은 제1항과 제2항의 처분 또는 명령을 한 때에는 지체없이 국회에 보고하여 그 승인을 얻어야 한다.",
                "교육의 자주성, 전문성, 정치적 중립성 및 대학의 자율성은 법률이 정하는 바에 의하여 보장된다."
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("사용할 도구를 정해주세요");
        String toolName = sc.nextLine();
        if(user.getTool(toolName)!=null){
            System.out.println("아래 문제를 정확히 같게 입력하세요!!");
            Timer timer = new Timer();
            double timeLimit = 20000;
            AtomicInteger answerCount = new AtomicInteger();
            AtomicInteger count = new AtomicInteger();
//            AtomicBoolean gameEnded = new AtomicBoolean(false);
            int earnCoin = 0;

            while (gameEnded.get()==false) {
                int random = new Random().nextInt(quiz.length);
                System.out.println("\n===== 라운드 " + (count.get() + 1) + " =====");
                System.out.println("문제: " + quiz[random]);
                System.out.println("제한 시간: " + String.format("%.2f", timeLimit / 1000) + "초");
                final boolean[] timeOutOccurred = {false};
                Thread inputThread = new Thread(() -> {
                    try {
                        String answer = sc.nextLine();
                        if (!timeOutOccurred[0]) {
                            if (answer.equals(quiz[random])) {
                                System.out.println("와우 정답이에요!!");
                                answerCount.getAndIncrement();
                                count.getAndIncrement();
                            } else {
                                System.out.println("오답입니다. 정확하게 입력하세요.");
                                count.getAndIncrement();
                            }
                        }
                    } catch (Exception e) {
                        System.out.println("힝~~~~~~~~~``");
                    }
                });
                TimerTask timeoutTask = new TimerTask() {
                    @Override
                    public void run() {
                        if (inputThread.isAlive()) {
                            timeOutOccurred[0] = true;
                            inputThread.interrupt();
                            System.out.println("시간 초과! 게임이 종료됩니다.");
                            displayResults(toolName, answerCount.get(), earnCoin,gameEnded);
                            gameEnded.set(true);
                        }
                    }
                };
                inputThread.start();
                timer.schedule(timeoutTask, (long) timeLimit);
                try {
                    inputThread.join((long) timeLimit);
                } catch (InterruptedException e) {
                    System.out.println();;
                }
                timeoutTask.cancel();
                if (timeLimit < 1000) {
                    System.out.println("제한 시간이 1초 미만입니다. 게임이 종료됩니다.");
                    gameEnded.set(true);
                    displayResults(toolName, answerCount.get(), earnCoin,gameEnded);
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println();
                }
                timeLimit *= 0.8;
            }
            timer.cancel();
            sc.close();
            gameEnded.set(true);
        }else{
            System.out.println("해당 도구가 없습니다. 뒤로 돌아갑니다.");
//            mainService.home();
        }
    }
    private static void displayResults(String toolName, int answerCount, int earnCoin, AtomicBoolean gameEnded) {
        System.out.println("\n게임 종료!");
        System.out.println("맞춘 문제의 개수는 : " + answerCount + "개 입니다!");
        if(Objects.equals(toolName, "고급 도구")){
            earnCoin = answerCount *12;
        }else {
            earnCoin = answerCount *10;
        }
        System.out.println("획득한 코인은 : " + earnCoin + "입니다!");
        int totalCoin = coin + earnCoin;
        user.setCoin(totalCoin);
        System.out.println("현재 총 코인은 : " + user.getCoin() + "개 입니다!");
        gameEnded.set(true);
//        mainService.home();
    }
}

