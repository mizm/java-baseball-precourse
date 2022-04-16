package baseball.service.dto;

public class GameResultDto {

    private int ballCount;
    private int strikeCount;

    public GameResultDto(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    @Override
    public String toString() {
        return "GameResultDto{" +
                ", ballCount=" + ballCount +
                ", strikeCount=" + strikeCount +
                '}';
    }
}
