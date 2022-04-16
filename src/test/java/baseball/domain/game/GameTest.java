package baseball.domain.game;

import baseball.domain.number.Numbers;
import baseball.domain.number.generator.StringNumbersGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    @ParameterizedTest
    @CsvSource(value = {"123:145:0:1", "123:456:0:0", "123:123:0:3"}, delimiter = ':')
    void 게임테스트(String question, String answer, int ballCount, int strikeCount) {
        //given
        StringNumbersGenerator numbersGenerator = new StringNumbersGenerator(question);
        Game game = Game.init(numbersGenerator);

        //when
        MatchResult matchResult = game.play(Player.from(Numbers.fromString(answer)));

        assertThat(matchResult).isEqualTo(MatchResult.of(ballCount, strikeCount));
    }
}