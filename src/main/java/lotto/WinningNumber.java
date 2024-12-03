package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WinningNumber{

    private List<Integer> winningNumbers;
    private int bonusNumber;

    public void setWinningNumbers(List<Integer> winningNumbers) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public void setBonusNumber(int bonusNumber) {
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        // 중복x
        Set<Integer> distinctNumbers = new HashSet<>(numbers);
        if(distinctNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }
        // 1~45
        if(numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 수만 가능합니다.");
        }
    }

    private void validateBonusNumber(int number) {
        if(winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 수만 가능합니다.");
        }
    }


}
