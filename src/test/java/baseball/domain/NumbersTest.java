package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumbersTest {

    @Test
    void create() {
        Numbers numbersFromString = Numbers.fromString("123");
        Numbers numbersFromList = Numbers.fromList(Arrays.asList(1, 2, 3));

        assertThat(numbersFromString).isEqualTo(numbersFromList);
    }

    @Test
    @DisplayName("중복된 숫자가 입력되면 IllegalArgumentException")
    void createSameNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.fromList(Arrays.asList(1, 1, 2)));
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.fromString("112"));
    }

    @Test
    @DisplayName("3개 숫자가 아닌 값이 입력되면 IllegalArgumentException")
    void createNoMatchCountException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.fromList(Arrays.asList(1, 2)));
        assertThatIllegalArgumentException().isThrownBy(() -> Numbers.fromString("1234"));
    }

    @DisplayName("볼인 경우 매치 result를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"123:456:0", "123:415:1", "123:234:2", "123:321:3"}, delimiter = ':')
    void ballCountTest(String input, String compare, int ballCount) {
        Numbers first = Numbers.fromString(input);
        Numbers second = Numbers.fromString(compare);

        assertThat(first.matchResult(second)).isEqualTo(MatchResult.of(ballCount, 0));
    }
}