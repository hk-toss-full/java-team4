package hospital;

import static info.Pet.getPet;
import static info.User.getUser;

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
        setTime();
    }

    private void setTime() {
        int time = random.nextInt(60) + 10;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                isSick = true;
                if (isSick = true) {
                    System.out.println("당신의 펫은 병에 걸렸습니다.");
                    System.out.println("당신의 펫은 치료하려면 0번, 치료하지 않으려면 1번을 입력하세요.");
                    int number = scanner.nextInt();
                    if (number == 0) {
                        getUser().setCoin(getUser().getCoin() - 300);
                        isSick = false;
                    } else {
                        System.out.println("당신의 펫은 치료받지 못해 죽었습니다.");

                        throw new IllegalArgumentException(PET_DIE_ERROR_MESSAGE);
                    }
                }
            }
        };
        timer.schedule(task, time);
    }
}