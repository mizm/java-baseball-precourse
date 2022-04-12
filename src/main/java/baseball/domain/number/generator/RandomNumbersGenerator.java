package baseball.domain.number.generator;

import baseball.domain.number.Number;
import baseball.domain.number.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
    @Override
    public Numbers generate() {
        List<Integer> nums = Randoms.pickUniqueNumbersInRange(Number.MIN, Number.MAX, Numbers.NUMBERS_MAX_SIZE);
        return Numbers.fromList(nums);
    }
}
