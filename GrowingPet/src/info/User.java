package info;

import java.util.HashMap;
import java.util.Map;

public class User {
    private static User user;
    private int coin;
    private Map<String, Integer> food = new HashMap<String, Integer>();
    private Map<String, Integer> tool = new HashMap<String, Integer>();
    private final int INITIAL_COIN = 100;
    private final int INITIAL_NORMAL_FOOD = 3;
    private final int INITIAL_GOOD_FOOD =0;
    private final int INITIAL_BEST_FOOD = 0;
    private final int INITIAL_NORMAL_TOOL = 0;
    private final int INITIAL_GOOD_TOOL = 0;

    private User(){
        coin = INITIAL_COIN;
        food.put("normalFood", INITIAL_NORMAL_FOOD);
        food.put("goodFood", INITIAL_GOOD_FOOD);
        food.put("bestFood", INITIAL_BEST_FOOD);

        tool.put("normalTool", INITIAL_NORMAL_TOOL);
        tool.put("goodTool", INITIAL_GOOD_TOOL);
    }

    public static User getUser(){
        if(user == null){
            user = new User();
        }
        return user;
    }

    public int getCoin() {
        return coin;
    }

    public Map<String, Integer> getFood() {
        return food;
    }

    public Map<String, Integer> getTool() {
        return tool;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public void showUser(){
        User user= User.getUser();
        System.out.println("보유 코인: "+user.getCoin());
        System.out.println("현재 사료 현황: "+user.getFood()+" 현재 도구 현황: "+user.getTool());
    }
}

