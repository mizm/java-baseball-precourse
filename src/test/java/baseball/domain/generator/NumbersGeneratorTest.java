package baseball.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersGeneratorTest {

    @Test
    @DisplayName("1~9 사이 중복되지 않은 3개의 숫자를 생성한다.")
    void generateTest() {
        NumbersGenerator generator1 = new StringNumbersGenerator("123");
        NumbersGenerator generator2 = new StringNumbersGenerator("123");
        assertThat(generator1.generate()).isEqualTo(generator2);
    }
}