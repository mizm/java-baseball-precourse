package baseball.domain.number.generator;

import baseball.domain.number.Number;
import baseball.domain.number.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RandomNumbersGenerator implements NumbersGenerator {
    @Override
    public Numbers generate() {
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() != Numbers.NUMBERS_MAX_SIZE) {
            numberSet.add(Randoms.pickNumberInRange(Number.MIN, Number.MAX));
        }
        return Numbers.fromList(new ArrayList<>(numberSet));
    }
}
