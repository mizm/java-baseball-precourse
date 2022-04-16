package baseball.controller.message;

import baseball.service.dto.GameResultDto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ResultMessageTest {

    @ParameterizedTest
    @CsvSource(value = {"0:1:1스트라이크", "0:0:낫싱", "2:0:2볼", "2:1:2볼 1스트라이크"}, delimiter = ':')
    void 메시지_테스트(int ballCount, int strikeCount, String message) {
        ResultMessage resultMessage = ResultMessage.from(new GameResultDto(ballCount, strikeCount));

        assertThat(resultMessage.message()).isEqualTo(message);
    }
}