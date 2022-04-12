package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    //Random 학습 테스트
    @Test
    void randomNumberTest() {
        List<Integer> integers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        System.out.println("integers = " + integers);
        assertThat(integers.size()).isEqualTo(3);
        HashSet<Integer> set = new HashSet<>(integers);
        assertThat(set.size()).isEqualTo(3);
        assertRange(integers);
    }

    private void assertRange(List<Integer> generate) {
        for (Integer num : generate) {
            assertThat(0 < num).isTrue();
            assertThat(num < 10).isTrue();
        }
    }
}
