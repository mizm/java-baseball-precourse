package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Balls {

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls fromString(String numberString) {
        String[] numbers = numberString.split("");
        List<Ball> balls = new ArrayList<>();
        for (String input : numbers) {
            balls.add(Ball.fromInteger(input));
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
