package mainController;

import info.Pet;

public class MainController {

    private static MainService mainService = MainService.getInstance();

    public static void run(){
        Pet.gameStart();
        while(true){
            mainService.home();
        }
    }
}
