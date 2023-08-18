package baseball.Domain;

import baseball.Model.TargetNum;
import baseball.View.OutPutView;
import baseball.gameIO.gameInput;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    int guessNum;
    boolean isAnswer;
    TargetNum target;
    Result result;

    public BaseballGame(){}

    public void playGame() {
        int gameProcess = 1;

        while (gameProcess == 1) {
            gameSetting();
            userGuessNum();
            gameProcess = isReStartGame();
        }
        return;
    }

    private void gameSetting() {
        guessNum = 0;
        isAnswer = false;
        target = new TargetNum();
        result = new Result();
    }

    private void userGuessNum() {
        while(isAnswer == false) {
            System.out.printf("숫자를 입력해 주세요. : ");
            guessNum = gameInput.inputGuessNum();
            isAnswer = result.checkAnswer(guessNum, target);
            OutPutView.printResult(result.getBS());
        }
    }

    private int isReStartGame(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
}
