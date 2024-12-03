package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("당첨 번호를 입력해주세요.");
        String input = Console.readLine();

        InputParser inputParser = new InputParser();
        List<Integer> numbers = inputParser.createWinningNumber(input);
    }
}
