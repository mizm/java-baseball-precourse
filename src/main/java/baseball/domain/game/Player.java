package baseball.domain.game;

import baseball.domain.number.Numbers;

public class Player {

    private final Numbers numbers;

    private Player(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Player from(Numbers numbers) {
        return new Player(numbers);
    }

    public MatchResult matchResult(Player player) {
        int ballCount = this.numbers.ballCount(player.numbers);
        int strikeCount = this.numbers.strikeCount(player.numbers);
        return MatchResult.of(ballCount, strikeCount);
    }
}
