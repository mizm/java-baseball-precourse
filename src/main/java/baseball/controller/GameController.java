package baseball.controller;

import baseball.controller.message.ResultMessage;
import baseball.domain.number.generator.RandomNumbersGenerator;
import baseball.service.GameService;
import baseball.service.dto.GameResultDto;
import baseball.service.enums.GameStatus;
import camp.nextstep.edu.missionutils.Console;

public class GameController {
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public void start() {
        GameService gameService = new GameService(new RandomNumbersGenerator());
        GameStatus gameStatus = GameStatus.RUNNING;
        while (gameStatus.equals(GameStatus.RUNNING)) {
            gameStatus = play(gameService);
        }
    }

    private GameStatus gameStatusByRestartMessage(GameService gameService) {
        System.out.println(GAME_END_MESSAGE);
        System.out.println(INPUT_GAME_RESTART_MESSAGE);
        GameStatus gameStatus = GameStatus.restartMessage(Console.readLine());
        if (gameStatus.equals(GameStatus.RUNNING)) {
            gameService.refresh();
        }
        return gameStatus;
    }

    private GameStatus play(GameService gameService) {
        while (gameService.isRunning()) {
            System.out.println(INPUT_NUMBERS_MESSAGE);
            String numbers = Console.readLine();
            GameResultDto result = gameService.play(numbers);
            matchResultView(result);
        }
        return gameStatusByRestartMessage(gameService);
    }

    private void matchResultView(GameResultDto result) {
        System.out.println(ResultMessage.from(result).message());
    }
}
