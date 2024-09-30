package info;

import java.util.Arrays;
import java.util.Random;

import static global.Utils.sc;

public class Pet implements Runnable {
    Random rand = new Random();

    private static Pet pet;

    public Integer getFullness() {
        return fullness;
    }

    private final String[] types = {"푸들", "포메라니안", "시츄"};
    private String type;
    private String name;
    private static final int MAX_NAME_LENGTH = 11;
    private static final String VALIDATE_NAME_LENGTH_ERROR_MESSAGE = "이름은 최대 10글자 입니다. 다시 실행하여주세요.";
    private Integer fullness = 50;
    private Integer level = 1;
    private Integer clean = 50;

    public void setFullness(Integer fullness) {
        this.fullness -= fullness;
    }

    public void setClean(Integer clean) {
        this.clean += clean;
        if (this.clean >= 100){
            System.out.println("아 그만 씼겨라 죽겄네");
            this.clean = 100;
        }
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getExperience() {
        return experience;
    }

    private Integer experience = 0;

    private static User user = User.getInstance();

    public Integer getClean() {
        return clean;
    }

    public static Pet getInstance2() {
        if (pet == null) {
            pet = new Pet();
        }
        return pet;
    }

    public static void gameStart() {
        System.out.println("게임을 시작하겠습니다.");
        System.out.print("펫의 이름을 입력하세요 : ");
        String idx = sc.nextLine();
        getInstance(idx);
        String type = pet.createType();
        System.out.println("당신의 반려견은 : " + type + "입니다.");
        user.showUser();
    }

    public String getType() {
        return type;
    }

    public static Pet getInstance(String name) {
        if (pet == null) {
            pet = new Pet(name);
        }
        return pet;
    }

    public Pet() {
    }

    private Pet(String name) {
        validateLength(name);
        this.type = type;
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(VALIDATE_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private String createType() {
        int num = rand.nextInt(2);
        return types[num];
    }

    @Override
    public String toString() {
        return "Pet{" + "rand=" + rand + ", types=" + Arrays.toString(types) + ", type='" + type + '\'' + ", name='"
                + name + '\'' + '}';
    }

    public static Pet getPet() {
        return pet;
    }

    public void addFullness(Integer range) {
        fullness += range;
        if (fullness >= 100) {
            fullness = 100;
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(10000); // 10초 대기
                decreaseFullness(10); // fullness 10 감소
                if (fullness <= 0) {
                    System.out.println("펫의 포만감이 0이 되었습니다. 사료를 먹여주세요.");
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void decreaseFullness(int amount) {
        fullness -= amount;
        if (fullness < 0) {
            fullness = 0;
        }
    }
}