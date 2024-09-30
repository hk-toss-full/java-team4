package info;

import java.util.Map;

public class User {
    private static User user;
    private int coin = 100;
    private Map<String,Integer> food = Map.of(
             "저급 사료", 50,
            "중급 사료", 100,
            "고급 사료" , 150
    );
    private Map<String, Integer> tool = Map.of(
            "기본 도구",30,
            "고급 도구", 60
    );
    private Map<String, Integer> clothes = Map.of(
            "기본 옷", 200,
            "특별 옷", 400
    );
    private final int INITIAL_COIN = 100;
    private final int INITIAL_STANDARD_FOOD = 3;
    private final int INITIAL_GOOD_FOOD = 0;
    private final int INITIAL_STANDARD_TOOL = 0;
    private final int INITIAL_GOOD_TOOL = 0;
    private static final String NOT_ENOUGH_COIN = "돈이 부족합니다.";

    public static User getInstance(){
        if(user == null){
            user = new User();
        }
        return user;
    }

    public void useCoin(int coin) {
        this.coin -= coin;
        if (this.coin < 0){
            throw new IllegalArgumentException(NOT_ENOUGH_COIN);
        }
    }

    public int getCoin() {
        return coin;
    }

    public Integer getFood(String item) {
        return food.get(item);
    }

    public Integer getClothes(String item) {
        return clothes.get(item);
    }

    public Integer getTool(String item) {
        return tool.get(item);
    }
}

