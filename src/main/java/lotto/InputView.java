package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    public int inputAmount() {
        while(true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String input = Console.readLine();
                System.out.println();

                return inputParser.parseAmount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> inputWinningNumbers() {
        while(true) {
            try {
                System.out.println("당첨 번호를 입력해주세요.");
                String input = Console.readLine();
                System.out.println();

                return inputParser.parseWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputBonusNumber() {
        while(true) {
            try {
                System.out.println("보너스 번호를 입력해주세요.");
                String input = Console.readLine();
                System.out.println();

                return inputParser.parseBonusNumber(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningNumber inputWinningNumber() {
        while(true) {
            try {
                WinningNumber winningNumber = new WinningNumber();

                List<Integer> winningNumbers = inputWinningNumbers();
                winningNumber.setWinningNumbers(winningNumbers);

                int bonusNumber = inputBonusNumber();
                winningNumber.setBonusNumber(bonusNumber);

                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}
