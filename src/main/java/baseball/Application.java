package baseball;

import baseball.Model.TargetNum;
import baseball.View.OutPutView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {

        int gameProcess = 1;
        int guessNum;
        boolean result = false;

        while(gameProcess == 1){
            TargetNum target = new TargetNum();
            guessNum = 0;
            result = false;

            while(result == false) {
                System.out.printf("숫자를 입력해 주세요. : ");
                guessNum = inputGuessNum();
                result = target.calResult(guessNum);
                OutPutView.printResult(target.getBSN());
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameProcess = Integer.parseInt(Console.readLine());
        }
    }

    public static int inputGuessNum() {
        String str = Console.readLine();
        if(str.length() != 3 || !isStringNumber(str)) throw new IllegalArgumentException();
        return Integer.parseInt(str);
    }

    public static boolean isStringNumber(String str) {
        String pattern ="^[0-9]+$";
        Pattern compiled = Pattern.compile(pattern);
        return compiled.matcher(str).matches();
    }
}
