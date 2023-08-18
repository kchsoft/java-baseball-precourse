package baseball.Domain;

import baseball.Model.TargetNum;

import java.util.HashMap;

public class Result {

    private int[] BS; // 00 -> BS -> Ball / Strike

    public Result(){}

    public boolean checkAnswer(int num, TargetNum target) {
        BS = new int[2];
        int[] guessArr = divideNum(num);
        char bsChar; // ball , strike

        for(int pos = 1 ; pos <= 3 ; pos++){
            bsChar = compareNum(guessArr[pos-1],pos,target.getTargetMap());
            setBS(bsChar);
        }

        if (BS[1] == 3) return true;
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

    private char compareNum(int guessNum,int guessPos ,HashMap<Integer,Integer> targetMap) {
       if(isNumExist(guessNum,targetMap)){
           if(isPosEqual(guessPos,targetMap.get(guessNum)))
               return 's'; // equal , strike
           else
               return 'b'; // different , ball
        }
        return 'n';
    }

    private boolean isNumExist(int guessNum , HashMap<Integer,Integer> targetMap) {
        return targetMap.containsKey(guessNum);
    }

    private boolean isPosEqual(int guessPos , int targetPos) {
        return guessPos == targetPos;
    }

    public int[] getBS() {
        return BS;
    }

    private void setBS(char bsChar) {
        if(bsChar == 'b') BS[0] += 1;
        if(bsChar == 's') BS[1] += 1;
        return;
    }
}
