package baseball;

import baseball.Domain.BaseballGame;
import baseball.Model.TargetNum;
import baseball.View.OutPutView;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        game.playGame();
    }


}
