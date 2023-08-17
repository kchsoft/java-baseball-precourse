package baseball.Model;

import java.util.HashMap;
import java.util.List;

public class TargetNum {

    private HashMap<Integer, Integer> target; // num : position
    private String BSN; // 000 -> BSN -> Ball / Strike / Nothing

    public TargetNum(List<Integer> list) {
        target = new HashMap<Integer,Integer>();
        target.put(list.get(0), 1);
        target.put(list.get(1), 2);
        target.put(list.get(2), 3);
        BSN = "000"; // init
    }

    public boolean calResult(int num) {
        if(num == 0) return true;

        int[] bs = {0, 0}; // Ball and Strike
        int[] guessArr = divideNum(num);

        compareNum(bs, guessArr[0], 1);
        compareNum(bs, guessArr[1], 2);
        compareNum(bs, guessArr[2], 3);
        setBSN(bs);

        if(bs[1] == 3) return false;
        return true;
    }

    private int[] divideNum(int num) {
        int[] arr = new int[3];

        arr[0] = num / 100;
        num %= 100;

        arr[1] = num / 10;
        num %= 10;

        arr[2] = num;
        return arr;
    }

    private void compareNum(int[] bs, int guessNum, int index) {
        if (target.containsKey(guessNum)) {
            if (target.get(guessNum) == index)
                bs[1] += 1;
            else
                bs[0] += 1;
        }
        return;
    }

    public String getBSN() {
        return BSN;
    }

    private void setBSN(int[] bs) {
        if (bs[0] == 0 && bs[1] == 0) {
            BSN = "001"; // Nothing
            return;
        }
        BSN = "" + bs[0] + bs[1] + "0";
        return;
    }
}
