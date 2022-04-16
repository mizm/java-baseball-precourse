package baseball.domain.game;

import baseball.domain.number.Numbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    @DisplayName("match Test")
    void matchTest() {
        Player player1 = Player.from(Numbers.fromString("123"));
        Player player2 = Player.from(Numbers.fromString("132"));

        assertThat(player1.matchResult(player2)).isEqualTo(MatchResult.of(2, 1));
    }
}