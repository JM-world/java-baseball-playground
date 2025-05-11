package baseball;

import java.util.ArrayList;
import java.util.List;

public class ParseUtils {
    public static List<Integer> parseList(String playerInput) {
        List<Integer> results = new ArrayList<>();
        for (char c : playerInput.toCharArray()) {
            results.add(Integer.parseInt(String.valueOf(c)));
        }
        return results;
    }
}
