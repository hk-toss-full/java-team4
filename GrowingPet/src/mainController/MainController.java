package mainController;

import info.Pet;

public class MainController {

    private static MainService mainService = MainService.getInstance();

    public static void run(){
        while(true){
            Pet.gameStart();
            mainService.home();
        }
    }
}
