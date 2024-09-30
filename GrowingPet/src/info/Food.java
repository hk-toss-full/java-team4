package info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Food {
    private static Food food;

    private List<String> info = Arrays.asList("저급사료", "저급사료", "저급사료");
    public static Food getInstance(){
        if(food == null){
            food = new Food();
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
