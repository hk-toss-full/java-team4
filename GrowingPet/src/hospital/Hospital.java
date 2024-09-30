package hospital;

import static info.Pet.getPet;
import static info.User.getUser;

import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Hospital {
    private boolean isSick = false;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public Hospital() {

        setTime();
    }

    private void setTime() {
        int time = random.nextInt(60) + 10;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                isSick = true;
                if (isSick = true) {
                    System.out.println("당신의 펫 " + getPet() + " 병에 걸렸습니다.");
                    System.out.println("당신의 펫 " + getPet() + " 치료하려면 0번, 치료하지 않으려면 1번을 입력하세요.");
                    int number = scanner.nextInt();
                    if (number == 1) {
                        getUser().setCoin(getUser().getCoin() - 300);
                        isSick = false;
                    }
                }
            }
        };
        timer.schedule(task, time * 1000);
    }
}
