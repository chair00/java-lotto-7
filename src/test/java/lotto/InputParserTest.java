package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputParserTest {

    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void exception_test1() {

        InputParser inputParser = new InputParser();
        String input = "1, 2, 3, 4, 5, 55";
        assertThatThrownBy(() -> inputParser.createWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 넘을 경우 예외가 발생한다.")
    @Test
    void exception_test2() {

        InputParser inputParser = new InputParser();
        String input = "1, 2, 3, 4, 5, 6, 7";
        assertThatThrownBy(() -> inputParser.createWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복될 경우 예외가 발생한다.")
    @Test
    void exception_test3() {

        InputParser inputParser = new InputParser();
        String input = "1, 2, 3, 4, 5, 5";
        assertThatThrownBy(() -> inputParser.createWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 공백이 있을 경우")
    @Test
    void exception_test4() {

        InputParser inputParser = new InputParser();
        String input = "1, 2, 3, 4, , 5, 6";
        assertThatThrownBy(() -> inputParser.createWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 공백을 입력할 경우")
    @Test
    void exception_test5() {

        InputParser inputParser = new InputParser();
        String input = "";
        assertThatThrownBy(() -> inputParser.createWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 숫자가 아닌 것을 입력할 경우")
    @Test
    void exception_test6() {

        InputParser inputParser = new InputParser();
        String input = "l,4";
        assertThatThrownBy(() -> inputParser.createWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}