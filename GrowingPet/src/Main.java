import mainController.MainController;

public class Main {
    public static void main(String[] args) {
        try {
            MainController.run();
        } catch (Exception e){
            System.out.println("잘못입력 했네용");
            MainController.run();
        }

    }
}
