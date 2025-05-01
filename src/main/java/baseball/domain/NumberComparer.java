package baseball.domain;

import java.util.List;

public class NumberComparer {
    public static Hint compare(List<Integer> computer, List<Integer> input) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computer.size(); i++) {
            strike += strikeCount(computer.get(i), input.get(i));
            ball += ballCount(computer, computer.get(i), input.get(i));
        }

        return new Hint(strike, ball);
    }

    private static int strikeCount(int expected, int number) {
        if (expected == number) {
            return 1;
        }
        return 0;
    }

    private static int ballCount(List<Integer> computer, int expected, int number) {
        if (expected != number && computer.contains(number)) {
            return 1;
        }
        return 0;
    }
}
