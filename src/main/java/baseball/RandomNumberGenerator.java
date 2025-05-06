package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator {
    public static List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 3);
    }
}
