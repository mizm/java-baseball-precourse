package baseball.domain.game;

import java.util.Objects;

public class MatchResult {

    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final int FULL_COUNT = 3;
    private static final MatchResult[][] MATCH_RESULT_ITEMS = {
            {
                    new MatchResult(0, 0),
                    new MatchResult(0, 1),
                    new MatchResult(0, 2),
                    new MatchResult(0, 3)
            },
            {
                    new MatchResult(1, 0),
                    new MatchResult(1, 1),
                    new MatchResult(1, 2)
            },
            {
                    new MatchResult(2, 0),
                    new MatchResult(2, 1)
            },
            {
                    new MatchResult(3, 0)
            },
    };
    private static final MatchResult initResult = MATCH_RESULT_ITEMS[0][0];
    private static final String FULL_COUNT_OVER_EXCEPTION_MESSAGE = "볼과 스트라이크의 합이 3을 넘을 수 없습니다.";
    private static final String LESS_THAN_ZERO_EXCEPTION_MESSAGE = "입력 값은 0보다 작을 수 없습니다.";

    private final int ball;
    private final int strike;

    private MatchResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public static MatchResult of(int ball, int strike) {
        validateLessThanZero(ball);
        validateLessThanZero(strike);
        if (ball + strike > FULL_COUNT) {
            throw new IllegalArgumentException(FULL_COUNT_OVER_EXCEPTION_MESSAGE);
        }
        return MATCH_RESULT_ITEMS[ball][strike];
    }

    private static void validateLessThanZero(int count) {
        if (count < ZERO) {
            throw new IllegalArgumentException(LESS_THAN_ZERO_EXCEPTION_MESSAGE);
        }
    }

    public static MatchResult init() {
        return initResult;
    }

    public boolean isEnd() {
        return ball == ZERO && strike == THREE;
    }

    public int ballCount() {
        return ball;
    }

    public int strikeCount() {
        return strike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return ball == that.ball && strike == that.strike;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, strike);
    }

    @Override
    public String toString() {
        return "MatchResult{" +
                "ball=" + ball +
                ", strike=" + strike +
                '}';
    }
}
