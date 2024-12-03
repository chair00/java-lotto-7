package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    // 구입 금액 입력
    public int parseAmount(String input) {
        try {
            int amount = Integer.parseInt(input);
            if (amount % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.");
            }
            if (amount <= 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 양수만 허용합니다.");
            }
            return amount;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 형식입니다.");
        }
    }

    // 당첨 번호 입력
    public List<Integer> parseWinningNumber(String input) {
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            return numbers;
        } catch(NumberFormatException e) {

            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 형식입니다.");
        }
    }

    // 보너스 번호 입력
    public int parseBonusNumber(String input) {
        try {
            int bonusNumber = Integer.parseInt(input);

            return bonusNumber;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 형식입니다.");
        }
    }
}
