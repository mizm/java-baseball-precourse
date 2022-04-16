package baseball.controller.message;

import baseball.service.dto.GameResultDto;

public class ResultMessage {

    private static final int ZERO = 0;
    private static final String BALL_MESSAGE_FORMAT = "%d볼";
    private static final String STRIKE_MESSAGE_FORMAT = "%d스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String EMPTY_MESSAGE = "";
    private static final String SPACE = " ";

    private int ballCount;
    private int strikeCount;

    private ResultMessage(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public static ResultMessage from(GameResultDto gameResultDto) {
        return new ResultMessage(gameResultDto.getBallCount(), gameResultDto.getStrikeCount());
    }

    public String message() {
        if (ballCount == ZERO && strikeCount == 0) {
            return NOTHING_MESSAGE;
        }

        String ballMessage = countMessage(BALL_MESSAGE_FORMAT, ballCount);
        String strikeMessage = countMessage(STRIKE_MESSAGE_FORMAT, strikeCount);

        return resultMessage(ballMessage, strikeMessage);
    }


    private String countMessage(String messageFormat, int count) {
        if (count == ZERO) {
            return EMPTY_MESSAGE;
        }
        return String.format(messageFormat, count);
    }

    private String resultMessage(String ballMessage, String strikeMessage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ballMessage).append(SPACE).append(strikeMessage);
        return stringBuilder.toString().trim();
    }
}
