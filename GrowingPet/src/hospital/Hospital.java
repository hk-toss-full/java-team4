package hospital;

import static info.User.getInstance;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Hospital {
    private boolean isSick = false;
    private static final String PET_DIE_ERROR_MESSAGE = "당신의 펫은 사망하였습니다.";
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public Hospital() {
        int time = random.nextInt(60) + 10;
        setTime(time);
    }

    private void setTime(int time) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                isSick = true;
                if (isSick = true) {
                    System.out.println("당신의 펫은 병에 걸렸습니다.");
                    goHospital();
                    String string = scanner.nextLine();
                    if (string.equals("치료")) {
                        getInstance().setCoin(getInstance().getCoin() - 300);
                        isSick = false;
                    } else {
                        System.out.println("당신의 펫은 치료받지 못해 죽었습니다.");

                        throw new IllegalArgumentException(PET_DIE_ERROR_MESSAGE);
                    }
                }else{
                    System.out.println("당신의 동물은 병에 걸리지 않았습니다.");
                }
            }
        };
        timer.schedule(task, time * 1000);
    }
    private void goHospital(){
        System.out.println("병원에 가세요");

    }
}