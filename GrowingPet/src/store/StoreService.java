package store;

import info.User;

public class StoreService {
    private static StoreService storeService;
    User user = User.getInstance();
    private StoreService() {
    }

    public static StoreService getInstance(){
        if (storeService == null){
            storeService = new StoreService();
        }
        return storeService;
    }
    public void buyFood(String item){
        Integer cost = user.getFood(item);
        user.useCoin(cost);
    }
    public void buyClothes(String item){
        Integer cost = user.getClothes(item);
        user.useCoin(cost);
    }
    public void buyTool(String item){
        Integer cost = user.getTool(item);
        user.useCoin(cost);
    }
}
