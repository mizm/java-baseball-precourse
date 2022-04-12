package baseball.domain.generator;

import baseball.domain.Number;
import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Number.MIN, Number.MAX, Numbers.NUMBERS_MAX_SIZE);
    }
}
