package info;

import java.util.ArrayList;
import java.util.List;

public class Tool {
    private static List<String> info = new ArrayList<>();
    private static Tool tool;
    public static Tool getInstance(){
        if(tool == null){
            tool = new Tool();
        }
        return tool;
    }

    private Tool() {
    }

    public void setInfo(String item) {
        Tool.info.add(item);
    }

    public List<String> getInfo() {
        return info;
    }
}
