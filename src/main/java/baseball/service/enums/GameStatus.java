package baseball.service.enums;

public enum GameStatus {

    RUNNING(1), END(2);

    final int value;

    GameStatus(int value) {
        this.value = value;
    }

    public static GameStatus restartMessage(String message) {
        if (Integer.valueOf(message).equals(RUNNING.value)) {
            return RUNNING;
        }

        return END;
    }
}
