package store;

import global.Utils;

import static global.Utils.sc;

public class StoreController {
    private static StoreController storeController;
    private StoreService storeService;

    private StoreController() {
        storeService = storeService.getInstance();
    }

    public static StoreController getInstance(){
        if (storeController == null){
            storeController = new StoreController();
        }
        return storeController;
    }

    public void buyFeed(){
        System.out.println("사료 사기: 저급 사료 50코인, 중급사료 100코인, 고급 사료 150 코인");
        System.out.println("구매하고 싶은 사료를 적어주세요 (ex. 저급 사료)");
        String item = sc.nextLine();


    }

    public void buyClothes(){
        System.out.println("옷 사기: 기본 옷 200 코인, 특별 옷 400 코인");
        System.out.println("구매하고 싶은 옷을 적어주세요 (ex. 기본 옷)");
        String item = sc.nextLine();

    }

    public void buyTraining(){
        System.out.println("훈련 도구 사기: 기본 도구 30 코인, 고급 도구 60 코인");
        System.out.println("구매하고 싶은 도구를 적어주세요 (ex. 기본 도구)");
        String item = sc.nextLine();
    }




}
