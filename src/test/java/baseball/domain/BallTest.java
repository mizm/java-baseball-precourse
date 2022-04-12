package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallTest {

    @Test
    @DisplayName("볼을 생성한다.")
    void create() {
        Ball ball = Ball.valueOf(5);
        assertThat(ball).isEqualTo(Ball.valueOf(5));
        assertThat(ball == Ball.valueOf(5)).isTrue();
    }

    @Test
    @DisplayName("볼을 생성할때 1~9 범위가 아니면 IleegalArgumentException이 발생한다.")
    void createAndException() {
        assertThatThrownBy(() -> {
            Ball.valueOf(0);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Ball.valueOf(10);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}