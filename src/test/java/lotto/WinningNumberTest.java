package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumberTest {

    @DisplayName("당첨 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void exception_winning_number_test1() {

        WinningNumber winningNumber = new WinningNumber();
        assertThatThrownBy(() -> winningNumber.setWinningNumbers(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 6개가 넘을 경우 예외가 발생한다.")
    @Test
    void exception_winning_number_test2() {

        WinningNumber winningNumber = new WinningNumber();
        assertThatThrownBy(() -> winningNumber.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호가 중복될 경우 예외가 발생한다.")
    @Test
    void exception_winning_number_test3() {

        WinningNumber winningNumber = new WinningNumber();
        assertThatThrownBy(() -> winningNumber.setWinningNumbers(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호에 범위를 벗어난 숫자가 있으면 예외가 발생한다.")
    @Test
    void exception_bonus_number_test1() {

        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningNumber.setBonusNumber(55))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복될 경우 예외가 발생한다.")
    @Test
    void exception_bonus_number_test2() {

        WinningNumber winningNumber = new WinningNumber();
        winningNumber.setWinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> winningNumber.setBonusNumber(2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}