package store;

import info.*;

import java.util.ArrayList;
import java.util.List;

public class StoreService {
    private static StoreService storeService;
    Clothes clothes = Clothes.getInstance();
    User user = User.getInstance();
    Food food = Food.getInstance();
    Pet pet = Pet.getInstance2();
    Tool tool = Tool.getInstance();

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
        food.addInfo(item);
    }
    public void buyClothes(String item){
        Integer cost = user.getClothes(item);
        user.useCoin(cost);
        clothes.setInfo(item);

    }
    public void buyTool(String item){
        Integer cost = user.getTool(item);
        tool.setInfo(item);
        user.useCoin(cost);
    }

    public ArrayList<String> myClothes(){
        ArrayList<String> isClothes = clothes.getInfo();
        return isClothes;
    }

    public List<String> myFood(){
        return food.getInfo();
    }

    public void useFood(String item){
        if (item.equals("저급 사료")){
            food.useFood(item);
            pet.addFullness(10);
        } else if (item.equals("중급 사료")) {
            food.useFood(item);
            pet.addFullness(30);
        } else if(item.equals("고급 사료")){
            food.useFood(item);
            pet.addFullness(50);
        }else{
            // 예외처리
        }
        food.useFood(item);

    }
}
