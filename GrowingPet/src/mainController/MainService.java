package mainController;

import com.sun.tools.javac.Main;
import game.Gamble;
import hospital.Hospital;
import info.Pet;
import store.StoreController;

import static global.Utils.sc;

public class MainService {
    StoreController storeController = StoreController.getInstance();
//    Hospital hospital = new Hospital();
    private static MainService mainService;
    public static MainService getInstance() {
        if (mainService == null) {
            mainService = new MainService();
        }
        return mainService;
    }

    private MainService() {
    }

    public void home(){
        System.out.println("어디로 가시겠습니까?");
        System.out.println("1: 집, 2: 상점, 3: 병원, 4: 도박장");
        Integer i = Integer.valueOf(sc.nextLine());
        switch (i){
            case 1:

                break;
            case 2:
                goStore();
                break;
            case 3:

                break;
            case 4:
                Gamble gamble = new Gamble();
                gamble.gamble();
                break;
        }
    }

    public void goStore(){
        System.out.println("어서오세요");
        System.out.println("무엇을 구입하시겠습니까?");
        System.out.println("1: 음식, 2: 의상, 3: 도구");
        Integer i = Integer.valueOf(sc.nextLine());
        switch (i){
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
}
