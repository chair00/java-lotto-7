package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputParser inputParser = new InputParser();
        WinningNumber winningNumber = new WinningNumber();

        System.out.println("구입 금액을 입력해주세요.");
        String input = Console.readLine();

        int amount = inputParser.parseAmount(input);
        LottoGame lottoGame = new LottoGame(amount);

        System.out.println("당첨 번호를 입력해주세요.");
        input = Console.readLine();

        List<Integer> winningNumbers = inputParser.parseWinningNumber(input);
        winningNumber.setWinningNumbers(winningNumbers);

        System.out.println("보너스 번호를 입력해주세요.");
        input = Console.readLine();

        int bonusNumber = inputParser.parseBonusNumber(input);
        winningNumber.setBonusNumber(bonusNumber);

        lottoGame.printPurchaseLottos();
    }
}
