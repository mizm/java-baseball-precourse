package baseball.domain.number;

import java.util.*;

public class Numbers {

    public static final int NUMBERS_MAX_SIZE = 3;
    private static final String NUMBERS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE = "공의 중복될 수 없으며 갯수는 3개 입니다.";
    private static final int ADD_COUNT = 1;
    private static final int NO_ADD_COUNT = 0;
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        Set<Number> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != NUMBERS_MAX_SIZE) {
            throw new IllegalArgumentException(NUMBERS_SIZE_NOT_MATCH_EXCEPTION_MESSAGE);
        }
        ArrayList<Number> copy = new ArrayList<>(numbers);
        this.numbers = copy;
    }

    public static Numbers from(List<Number> numbers) {
        return new Numbers(numbers);
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

    public int ballCount(Numbers compare) {
        int ballCount = 0;
        for (Number number : this.numbers) {
            ballCount += countIsBall(number, compare);
        }
        return ballCount;
    }

    public int strikeCount(Numbers compare) {
        int strikeCount = 0;
        for (Number number : this.numbers) {
            strikeCount += countIsStrike(number, compare);
        }
        return strikeCount;
    }

    private boolean contains(Number number, Numbers compare) {
        return compare.numbers.contains(number);
    }

    private boolean isSameIndex(Number number, Numbers compare) {
        return this.numbers.indexOf(number) == compare.numbers.indexOf(number);
    }

    private int countIsBall(Number number, Numbers compare) {
        if (!contains(number, compare)) {
            return NO_ADD_COUNT;
        }

        if (isSameIndex(number, compare)) {
            return NO_ADD_COUNT;
        }

        return ADD_COUNT;
    }

    private int countIsStrike(Number number, Numbers compare) {
        if (!contains(number, compare)) {
            return NO_ADD_COUNT;
        }

        if (!isSameIndex(number, compare)) {
            return NO_ADD_COUNT;
        }

        return ADD_COUNT;
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
