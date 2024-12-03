package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.Lotto.validate;

public class InputParser {

    // 당첨 번호 입력
    public List<Integer> createWinningNumber(String input) {
        // 쉼표로 분리
        try {
            List<Integer> numbers = Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            validate(numbers);
            return numbers;
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 잘못된 숫자 형식입니다.");
        }
    }
}
