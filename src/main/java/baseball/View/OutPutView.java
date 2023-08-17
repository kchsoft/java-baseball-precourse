package baseball.View;
import camp.nextstep.edu.missionutils.Console;

public class OutPutView {
    public OutPutView() {}
    public static void printResult(String BSN) {
        if(BSN.equals("000")) return;

        String message = "";
        String[] bsnArr = BSN.split("");

        if(bsnArr[2].equals("1")){
            System.out.println("낫싱");
            return;
        }

        if(!bsnArr[0].equals("0")) message += bsnArr[0] + "볼 ";
        if(!bsnArr[1].equals("0")) message += bsnArr[1] +"스트라이크";
        System.out.println(message);
        return;
    }
}

