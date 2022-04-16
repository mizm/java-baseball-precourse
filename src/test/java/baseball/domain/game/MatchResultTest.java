package baseball.domain.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MatchResultTest {

    @Test
    void 생성_테스트() {
        MatchResult matchResult = MatchResult.init();
        MatchResult of = MatchResult.of(0, 0);
        assertThat(matchResult).isEqualTo(of);
    }

    @ParameterizedTest
    @CsvSource(value = {"-1:-1", "4:0", "2:2"}, delimiter = ':')
    void 생성_실패_테스트(int ballCount, int strikeCount) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            MatchResult.of(ballCount, strikeCount);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "2:0", "2:1"}, delimiter = ':')
    void getter_테스트(int ballCount, int strikeCount) {
        MatchResult matchResult = MatchResult.of(ballCount, strikeCount);
        
        assertThat(matchResult.ballCount()).isEqualTo(ballCount);
        assertThat(matchResult.strikeCount()).isEqualTo(strikeCount);
    }
}