package baseball.service;

import baseball.domain.game.Game;
import baseball.domain.game.MatchResult;
import baseball.domain.game.Player;
import baseball.domain.number.generator.NumbersGenerator;
import baseball.domain.number.generator.StringNumbersGenerator;
import baseball.service.dto.GameResultDto;

public class GameService {

    private Game game;
    private NumbersGenerator numbersGenerator;
    private MatchResult result;

    public GameService(NumbersGenerator numbersGenerator) {
        this.numbersGenerator = numbersGenerator;
        this.game = Game.init(numbersGenerator);
        this.result = MatchResult.init();
    }

    public GameResultDto play(String numbers) {
        NumbersGenerator generator = new StringNumbersGenerator(numbers);
        Player player = Player.from(generator.generate());
        result = game.play(player);
        return new GameResultDto(result.ballCount(), result.strikeCount());
    }

    public boolean isRunning() {
        return !isEnd();
    }

    public boolean isEnd() {
        return result.isEnd();
    }

    public void refresh() {
        game = game.init(numbersGenerator);
        result = MatchResult.init();
    }
}
