package info;

import java.util.*;

public class Clothes {
    private static Map<String, Boolean> info = new HashMap<>();
    private static Clothes clothes;
    private static User user = User.getInstance();
    public static Clothes getInstance(){
        if(clothes == null){
            clothes = new Clothes();
            info.put("기본 옷", false);
            info.put("특별 옷", false);
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
