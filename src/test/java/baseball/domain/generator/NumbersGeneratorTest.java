package baseball.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersGeneratorTest {

    @Test
    @DisplayName("1~9 사이 중복되지 않은 3개의 숫자를 생성한다.")
    void generateTest() {
        NumbersGenerator generator = new RandomNumbersGenerator();
        List<Integer> generate = generator.generate();
        assertThat(generate.size()).isEqualTo(3);
        HashSet<Integer> numberSet = new HashSet<>(generate);
        assertThat(numberSet.size()).isEqualTo(3);

        assertRange(generate);
    }

    private void assertRange(List<Integer> generate) {
        for (Integer num : generate) {
            assertThat(0 < num).isTrue();
            assertThat(num < 10).isTrue();
        }
    }
}