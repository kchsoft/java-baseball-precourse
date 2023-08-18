package baseball.View;
import camp.nextstep.edu.missionutils.Console;

public class OutPutView {
    public OutPutView() {}
    public static void printResult(int[] BS) {
        String message = "";

        if(BS[0] == 0 && BS[1] == 0){
            System.out.println("낫싱");
            return;
        }

        if(BS[0] >= 1) message += BS[0] + "볼 ";
        if(BS[1] >= 1) message += BS[1] +"스트라이크";
        System.out.println(message);
        return;
    }
}

