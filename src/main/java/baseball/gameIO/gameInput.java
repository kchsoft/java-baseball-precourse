package baseball.gameIO;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class gameInput {
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
