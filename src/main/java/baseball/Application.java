package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int gameProcess = 1;

        while(gameProcess == 1){
            System.out.printf("숫자를 입력해 주세요. : ");
            String tmp =  Console.readLine(); // tmp -> user input

            if(true) { // if user input answer
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                gameProcess = Integer.parseInt(Console.readLine());
            }
        }

    }
}
