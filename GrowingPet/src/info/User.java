package info;

import java.util.HashMap;
import java.util.Map;

public class User {
    private static User user;
    private int coin;
    private Map<Integer, String> food = new HashMap<Integer, String>();
    private Map<Integer, String> tool = new HashMap<Integer, String>();
    private final int INITIAL_COIN = 100;
    private final int INITIAL_STANDARD_FOOD = 3;
    private final int INITIAL_GOOD_FOOD = 0;
    private final int INITIAL_STANDARD_TOOL = 0;
    private final int INITIAL_GOOD_TOOL = 0;

    public static User getInstance(){
        if(user == null){
            user = new User();
        }
        return user;
    }

    public int getCoin() {
        return coin;
    }

    public Map<Integer, String> getFood() {
        return food;
    }

    public Map<Integer, String> getTool() {
        return tool;
    }
}

