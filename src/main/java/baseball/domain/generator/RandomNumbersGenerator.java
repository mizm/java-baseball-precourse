package baseball.domain.generator;

import baseball.domain.Ball;
import baseball.domain.Balls;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumbersGenerator implements NumbersGenerator {
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(Ball.MIN, Ball.MAX, Balls.BALLS_MAX_SIZE);
    }
}
