package baseball.domain.game;

import baseball.domain.number.Numbers;

public class Player {

    private final Numbers numbers;

    public Player(Numbers numbers) {
        this.numbers = numbers;
    }

    public MatchResult matchResult(Player player) {
        int ballCount = this.numbers.ballCount(player.numbers);
        int strikeCount = this.numbers.strikeCount(player.numbers);
        return MatchResult.of(ballCount, strikeCount);
    }
}
