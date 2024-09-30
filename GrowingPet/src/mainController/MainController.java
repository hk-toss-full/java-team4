package mainController;

import info.Pet;

public class MainController {

    private static MainService mainService = MainService.getInstance();
    private static MainController mainController;
    public static MainController getInstance(){
        if (mainController == null){
            mainController = new MainController();
        }
        return mainController;
    }
    public static void run(){
        Pet.gameStart();
        while(true){
            mainService.home();
        }
    }
}
