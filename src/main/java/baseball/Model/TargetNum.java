package baseball.Model;

import java.util.HashMap;
import java.util.List;

public class TargetNum {

    private HashMap<Integer, Integer> target; // num : position
    private String BSN; // 000 -> BSN -> Ball / Strike / Nothing

    public TargetNum(List<Integer> list) {
        target.put(list.get(0), 1);
        target.put(list.get(1), 2);
        target.put(list.get(2), 3);
        BSN = "000"; // init
    }

}
