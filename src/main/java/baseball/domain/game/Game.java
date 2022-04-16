package baseball.domain.game;

import baseball.domain.number.generator.NumbersGenerator;

public class Game {

    private final Player computer;

    private Game(Player computer) {
        this.computer = computer;
    }

    public static Game init(NumbersGenerator generator) {
        return new Game(Player.from(generator.generate()));
    }

    public MatchResult play(Player player) {
        return computer.matchResult(player);
    }


}


