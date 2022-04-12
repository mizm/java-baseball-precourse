package baseball.domain.generator;

import baseball.domain.Number;
import baseball.domain.Numbers;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
    @Override
    public Numbers generate() {
        List<Integer> nums = Randoms.pickUniqueNumbersInRange(Number.MIN, Number.MAX, Numbers.NUMBERS_MAX_SIZE);
        return Numbers.fromList(nums);
    }
}
