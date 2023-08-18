package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;

public class TargetNum {

    private HashMap<Integer, Integer> targetMap; // num : position
    private int[] numCheck;

    public TargetNum() {
        numCheck = new int[10];
        targetMap = new HashMap<Integer, Integer>();
        setRandNum();
    }


    public HashMap<Integer, Integer> getTargetMap() {
        return targetMap;
    }

    private void setRandNum() {
        int num;
        int index = 1;
        while (index <= 3) {
            num = Randoms.pickNumberInRange(1, 9);
            numCheck[num]++;
            if (numCheck[num] == 1) {
                targetMap.put(num, index);
                index++;
            }
        }
    }
}
