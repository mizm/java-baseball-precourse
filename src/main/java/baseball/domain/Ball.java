package baseball.domain;

import java.util.Objects;

public class Ball {

    public static final int MIN = 1;
    public static final int MAX = 9;
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "공의 숫자 범위는 1~9 입니다.";
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력 값은 빈 값 일 수 없습니다.";
    private static final Ball[] ZERO_THROUGH_NINE = {
            new Ball(0),
            new Ball(1),
            new Ball(2),
            new Ball(3),
            new Ball(4),
            new Ball(5),
            new Ball(6),
            new Ball(7),
            new Ball(8),
            new Ball(9)
    };

    private final int number;

    private Ball(int number) {
        this.number = number;
    }

    private static void validateNumberRange(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateNotNumber(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXCEPTION_MESSAGE);
        }

        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION_MESSAGE);
        }
    }

    public static Ball fromInteger(int number) {
        validateNumberRange(number);
        return ZERO_THROUGH_NINE[number];
    }

    public static Ball fromString(String number) {
        validateNotNumber(number);
        return fromInteger(Integer.parseInt(number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
