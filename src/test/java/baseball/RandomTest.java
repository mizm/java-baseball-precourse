package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RandomTest {
    //Random 학습 테스트
    @Test
    void randomNumberTest() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        System.out.println("integers = " + integers);
    }
}
