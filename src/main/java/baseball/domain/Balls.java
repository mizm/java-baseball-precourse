package baseball.domain;

import java.util.*;

public class Balls {

    private static final int BALLS_MAX_SIZE = 3;
    private static final String BALLS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE = "공의 중복될 수 없으며 갯수는 3개 입니다.";
    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        Set<Ball> ballSet = new HashSet<>(balls);
        if (ballSet.size() != BALLS_MAX_SIZE) {
            throw new IllegalArgumentException(BALLS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE);
        }
        this.balls = balls;
    }

    public static Balls fromString(String numberString) {
        String[] numbers = numberString.split("");
        List<Ball> balls = new ArrayList<>();
        for (String input : numbers) {
            balls.add(Ball.fromString(input));
        }
        return new Balls(balls);
    }

    public static Balls fromList(List<Integer> numbers) {
        List<Ball> balls = new ArrayList<>();
        for (Integer number : numbers) {
            balls.add(Ball.fromInteger(number));
        }
        return new Balls(balls);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Balls balls1 = (Balls) o;
        return Objects.equals(balls, balls1.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}
