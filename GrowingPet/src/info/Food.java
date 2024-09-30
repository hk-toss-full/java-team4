package info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Food {
    private static Food food;

    private static List<String> info = new ArrayList<>();
    public static Food getInstance(){
        if(food == null){
            food = new Food();
            info.add("저급 사료");
            info.add("저급 사료");
            info.add("저급 사료");
        }
        return food;
    }

    public List<String> getInfo() {
        return info;
    }

    public void addInfo(String item){
        info.add(item);
    }
    public void useFood(String item){
        info.remove(item);
    }
}
