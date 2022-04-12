package baseball.domain;

import java.util.Objects;

public class Number {

    public static final int MIN = 1;
    public static final int MAX = 9;
    private static final String NUMBER_RANGE_EXCEPTION_MESSAGE = "공의 숫자 범위는 1~9 입니다.";
    private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "입력 값이 숫자가 아닙니다.";
    private static final String EMPTY_EXCEPTION_MESSAGE = "입력 값은 빈 값 일 수 없습니다.";
    private static final Number[] ZERO_THROUGH_NINE = {
            new Number(0),
            new Number(1),
            new Number(2),
            new Number(3),
            new Number(4),
            new Number(5),
            new Number(6),
            new Number(7),
            new Number(8),
            new Number(9)
    };

    private final int number;

    private Number(int number) {
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

    public static Number fromInteger(int number) {
        validateNumberRange(number);
        return ZERO_THROUGH_NINE[number];
    }

    public static Number fromString(String number) {
        validateNotNumber(number);
        return fromInteger(Integer.parseInt(number));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
