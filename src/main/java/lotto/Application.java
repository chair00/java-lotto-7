package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputParser inputParser = new InputParser();
        InputView inputView = new InputView(inputParser);

        int amount = inputView.inputAmount();
        WinningNumber winningNumber = inputView.inputWinningNumber();

        LottoGame lottoGame = new LottoGame(amount, winningNumber);
        lottoGame.printPurchaseLottos();

        lottoGame.printLottoStatics();
    }
}
