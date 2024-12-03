package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;
    private int amount;
    private int lottoCount;
    private WinningNumber winningNumber;
    private int result[] = new int[5];

    public LottoGame(int amount, WinningNumber winningNumber) {
        this.amount = amount;
        this.lottoCount = amount / 1000;
        lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Lotto.drawLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        this.winningNumber = winningNumber;
    }

    public void printPurchaseLottos() {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            lotto.printLotto();
        }
        System.out.println();
    }

    public void calcResult() {
        for(Lotto lotto : lottos) {
            int matchNumber = lotto.countMatchingNumbers(winningNumber.getWinningNumbers());
            boolean hasBonus = lotto.hasBonus(winningNumber.getBonusNumber());
            LottoMatch lottoMatch = LottoMatch.getRank(matchNumber, hasBonus);

            if (lottoMatch != null) {
                result[lottoMatch.ordinal()]++;
            }
        }
    }

    public void printLottoStatics() {
        calcResult();

        System.out.println("당첨 통계");
        System.out.println("---");

        int index = 0;
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            StringBuilder result = new StringBuilder();
            result.append(lottoMatch.getMatchNumber() + "개 일치");
            if (lottoMatch.HasBonus()) {
                result.append(", 보너스 볼 일치");
            }
            result.append(" (" + String.format("%,d", lottoMatch.getPrize()) + "원) - " + this.result[index++] + "개");
            System.out.println(result);
        }
        System.out.println("총 수익률은 " + calcRateOfReturn() + "%입니다.");
        System.out.println();
    }

    public double calcRateOfReturn() {
        int netProfit = 0;

        int index = 0;
        for (LottoMatch lottoMatch : LottoMatch.values()) {
            netProfit += lottoMatch.getPrize() * result[index++];
        }
        double rateOfReturn = (double) netProfit / amount * 100;
        return Math.round(rateOfReturn * 100) / 100.0;
    }
}
