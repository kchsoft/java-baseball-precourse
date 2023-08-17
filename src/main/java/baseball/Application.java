package baseball;

import baseball.Model.TargetNum;
import baseball.View.OutPutView;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        int gameProcess = 1;
        int guessNum = 0;

        while(gameProcess == 1){
            TargetNum target = new TargetNum(Randoms.pickUniqueNumbersInRange(1, 10, 3));

            while(target.calResult(guessNum)) {
                OutPutView.printResult(target.getBSN());
                System.out.printf("숫자를 입력해 주세요. : ");
                guessNum =  Integer.parseInt(Console.readLine());
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            gameProcess = Integer.parseInt(Console.readLine());
        }
    }
}
