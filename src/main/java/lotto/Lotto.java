package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
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

    public static List<Integer> drawLottoNumbers() {

        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void printLotto() {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        System.out.println(sortNumbers.toString());
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {

        int matchNumber = 0;
        for(int winningNumber : winningNumbers) {
            if(numbers.contains(winningNumber)) {
                matchNumber++;
            }
        }
        return matchNumber;
    }

    public boolean hasBonus(int bonusNumber) {

        return numbers.contains(bonusNumber);
    }
}
