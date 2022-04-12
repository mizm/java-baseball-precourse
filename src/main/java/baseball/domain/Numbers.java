package baseball.domain;

import java.util.*;

public class Numbers {

    public static final int NUMBERS_MAX_SIZE = 3;
    private static final String NUMBERS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE = "공의 중복될 수 없으며 갯수는 3개 입니다.";
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        Set<Number> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != NUMBERS_MAX_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE);
        }
        this.numbers = numbers;
    }

    public static Numbers fromString(String numberString) {
        String[] numbers = numberString.split("");
        List<Number> balls = new ArrayList<>();
        for (String input : numbers) {
            balls.add(Number.fromString(input));
        }
        return new Numbers(balls);
    }

    public static Numbers fromList(List<Integer> numbers) {
        List<Number> balls = new ArrayList<>();
        for (Integer number : numbers) {
            balls.add(Number.fromInteger(number));
        }
        return new Numbers(balls);
    }

    public MatchResult matchResult(Numbers compare) {
        if (this.equals(compare)) {
            return MatchResult.threeStrike();
        }
        int ballCount = 0;
        int strikeCount = 0;
        for (Number number : this.numbers) {

        }
        return MatchResult.of(1, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers1 = (Numbers) o;
        return Objects.equals(numbers, numbers1.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

}
