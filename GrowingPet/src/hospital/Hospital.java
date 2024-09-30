package hospital;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Hospital {
    private boolean isSick = false;
    Random random = new Random();

    public Hospital() {
        int time = random.nextInt(50) + 10; // 10분에서 60분 사이의 랜덤 시간
        setTime(1);  // 병에 걸리는 시간 설정
    }

    // 펫이 병에 걸리는 타이머 설정
    private void setTime(int time) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                isSick = true;
                if (isSick) {
                    System.out.println("당신의 펫은 병에 걸렸습니다.");
                    for (int i = 0; i < 3; i++) {
                        goHospital();
                    }
                } else {
                    System.out.println("당신의 동물은 병에 걸리지 않았습니다.");
                }
            }
        };
        long delay = (long) time * 60 * 1000; // 분을 밀리초로 변환
        timer.schedule(task, delay);
    }

    // 병원에 가는 타이머 설정
    private void goHospital() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                if (isSick) {
                    System.out.println("병원에 가야 합니다.");
                }
            }
        };
        timer.schedule(task, 60 * 1000);
    }
}