package baseball.domain.generator;

import baseball.domain.Numbers;

public class StringNumbersGenerator implements NumbersGenerator {

    private final String numString;

    public StringNumbersGenerator(String numString) {
        this.numString = numString;
    }

    @Override
    public Numbers generate() {
        return Numbers.fromString(numString);
    }
}
