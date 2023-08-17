package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;

public class TargetNum {

    private HashMap<Integer, Integer> targetMap; // num : position
    private String BSN; // 000 -> BSN -> Ball / Strike / Nothing
    private int[] numCheck;

    public TargetNum() {
        numCheck = new int[10];
        targetMap = new HashMap<Integer, Integer>();
        setRandNum();

        BSN = "000"; // init
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

    public boolean calResult(int num) {
        int[] bs = {0, 0}; // Ball and Strike
        int[] guessArr = divideNum(num);

        compareNum(bs, guessArr[0], 1);
        compareNum(bs, guessArr[1], 2);
        compareNum(bs, guessArr[2], 3);
        setBSN(bs);

        if (bs[1] == 3) return true;
        return false;
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
        if (targetMap.containsKey(guessNum)) {
            if (targetMap.get(guessNum) == index)
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
