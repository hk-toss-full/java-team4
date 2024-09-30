package info;

import java.util.*;

public class Clothes {
    private Map<String, Boolean> info = Map.of(
            "기본 옷", false,
            "특별 옷", false
    );
    private static Clothes clothes;
    public static Clothes getInstance(){
        if(clothes == null){
            clothes = new Clothes();
        }
        return clothes;
    }

    public void setInfo(String item) {
        info.put(item, true);
    }

    public ArrayList<String> getInfo() {
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, Boolean> entry : info.entrySet()) {
            if (entry.getValue()) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
