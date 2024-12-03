package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {

    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void exception_winning_number_test1() {

        InputParser inputParser = new InputParser();
        String input = "1, 2, 3, 4, 5, 55";
        assertThatThrownBy(() -> inputParser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 넘을 경우 예외가 발생한다.")
    @Test
    void exception_winning_number_test2() {

        InputParser inputParser = new InputParser();
        String input = "1, 2, 3, 4, 5, 6, 7";
        assertThatThrownBy(() -> inputParser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복될 경우 예외가 발생한다.")
    @Test
    void exception_winning_number_test3() {

        InputParser inputParser = new InputParser();
        String input = "1, 2, 3, 4, 5, 5";
        assertThatThrownBy(() -> inputParser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 공백이 있을 경우")
    @Test
    void exception_winning_number_test4() {

        InputParser inputParser = new InputParser();
        String input = "1, 2, 3, 4, , 5, 6";
        assertThatThrownBy(() -> inputParser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 공백을 입력할 경우")
    @Test
    void exception_winning_number_test5() {

        InputParser inputParser = new InputParser();
        String input = "";
        assertThatThrownBy(() -> inputParser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 것을 입력할 경우")
    @Test
    void exception_winning_number_test6() {

        InputParser inputParser = new InputParser();
        String input = "l,4";
        assertThatThrownBy(() -> inputParser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 숫자가 아닌 것을 입력할 경우")
    @Test
    void exception_amount_test1() {

        InputParser inputParser = new InputParser();
        String input = "l";
        assertThatThrownBy(() -> inputParser.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 1,000으로 나누어 떨어지지 않는 값을 입력할 경우")
    @Test
    void exception_amount_test2() {

        InputParser inputParser = new InputParser();
        String input = "2500";
        assertThatThrownBy(() -> inputParser.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 양수를 입력하지 않은 경우")
    @Test
    void exception_amount_test3() {

        InputParser inputParser = new InputParser();
        String input = "-2000";
        assertThatThrownBy(() -> inputParser.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 양수를 입력하지 않은 경우 - 2")
    @Test
    void exception_amount_test4() {

        InputParser inputParser = new InputParser();
        String input = "0";
        assertThatThrownBy(() -> inputParser.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 공백을 입력한 경우")
    @Test
    void exception_amount_test5() {

        InputParser inputParser = new InputParser();
        String input = "";
        assertThatThrownBy(() -> inputParser.parseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}