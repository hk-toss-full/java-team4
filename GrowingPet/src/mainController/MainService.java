package mainController;

import com.sun.tools.javac.Main;
import game.Gamble;

import static info.User.getInstance;

import hospital.Hospital;
import info.Food;
import info.Pet;
import info.User;
import store.StoreController;

import java.sql.SQLOutput;

import static global.Utils.sc;

public class MainService {
    StoreController storeController = StoreController.getInstance();
    Hospital hospital = new Hospital();
    private static MainService mainService = MainService.getInstance();
    private static User user = User.getInstance();
    private static Pet pet = Pet.getInstance2();
    private static Food food = Food.getInstance();

    public static MainService getInstance() {
        if (mainService == null) {
            mainService = new MainService();
        }
        return mainService;
    }

    private MainService() {
    }

    public void home() {
        System.out.println("어디로 가시겠습니까?");
        System.out.println("1: 집, 2: 상점, 3: 병원, 4: 도박장");
        Integer i = Integer.valueOf(sc.nextLine());
        switch (i) {
            case 1:
                goHouse();
                break;
            case 2:
                goStore();
                break;
            case 3:
                goHospital();
                break;
            case 4:
                Gamble gamble = new Gamble();
                gamble.gamble();
                break;
        }
    }

    private void goHospital() {
        System.out.println("어서오세요. 병원입니다.");
        System.out.println("당신의 펫을 치료 하실건가요?");
        System.out.println("당신의 펫을 치료하려면 1을 누르세요.");
        System.out.println("비용은 300 골드 입니다..");
        int number = sc.nextInt();
        if (number == 1) {
            user.setCoin(user.getCoin() - 300);
            hospital.setSick(false);
            System.out.println("치료 완료~");
            Hospital hospital = new Hospital();
        } else {
            System.out.println("당신의 펫을 치료해야합니다.");

        }
    }

    public void goStore() {
        System.out.println("어서오세요");
        System.out.println("무엇을 구입하시겠습니까?");
        System.out.println("1: 음식, 2: 의상, 3: 도구");
        Integer i = Integer.valueOf(sc.nextLine());
        switch (i) {
            case 1:
                storeController.buyFood();
                break;
            case 2:
                storeController.buyClothes();
                break;
            case 3:
                storeController.buyTool();
                break;
        }
        Hospital hospital = new Hospital();
    }

    public void goHouse() {
        user.showUser();
        printAnimal();

        System.out.println("포만감 : " + pet.getFullness());
        System.out.println("청결도 : " + pet.getClean());
        System.out.println("성장 레벨 : " + pet.getLevel() + ", 경험치 : " + pet.getExperience());
        System.out.println("============액션============");
        System.out.println("1: 밥주기, 2: 씻겨주기, 3: 산책하기, 4: 훈련하기(타자연습)");
        Integer idx = Integer.valueOf(sc.nextLine());
        action(idx);
    }

    public void action(Integer idx) {
        switch (idx) {
            case 1:
                System.out.println(food.getInfo());
                System.out.println("무엇을 주시겠습니까?");
                storeController.useFood();
                break;
            case 2:
                System.out.println("열심히 닦는 중");
                System.out.println("슥싹슥싹");
                System.out.println("히힛 오줌발싸");
                pet.setClean(10);
                break;
            case 3:
                System.out.println("산책가는 중");
                System.out.println("냄새 맡는 중");
                pet.setFullness(20);
                break;
            case 4:

                break;
        }
    }

    void printAnimal() {
        System.out.println();
        int num = (int) (Math.random() * 2);
        if (num == 0) {
            System.out.println(" (\\__/)\n( •ㅅ• )\n づ ⊂  )");
        } else if (num == 1) {
            System.out.println("(\\__/) \n( ^ㅅ^ )♡\n/ >♥< \"");
        } else {
            System.out.println("(•ㅅ•)\n/ 　 づ");
        }

    }
}
