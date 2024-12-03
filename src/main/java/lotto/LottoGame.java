package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos;
    int amount;
    int lottoCount;

    public LottoGame(int amount) {
        this.amount = amount;
        this.lottoCount = amount / 1000;
        lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++){
            List<Integer> numbers = Lotto.drawLottoNumbers();
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
    }

    public void printPurchaseLottos() {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for(Lotto lotto : lottos) {
            lotto.printLotto();
        }
    }
}
