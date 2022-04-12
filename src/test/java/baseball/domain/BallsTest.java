package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class BallsTest {

    @Test
    void create() {
        Balls ballsFromString = Balls.fromString("123");
        Balls ballsFromList = Balls.fromList(Arrays.asList(1, 2, 3));

        assertThat(ballsFromString).isEqualTo(ballsFromList);
    }

    @Test
    @DisplayName("중복된 숫자가 입력되면 IllegalArgumentException")
    void createSameNumberException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.fromList(Arrays.asList(1, 1, 2)));
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.fromString("112"));
    }

    @Test
    @DisplayName("3개 숫자가 아닌 값이 입력되면 IllegalArgumentException")
    void createNoMatchCountException() {
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.fromList(Arrays.asList(1, 2)));
        assertThatIllegalArgumentException().isThrownBy(() -> Balls.fromString("1234"));
    }

}