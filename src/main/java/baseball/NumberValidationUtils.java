package baseball;

import java.util.HashSet;
import java.util.List;

public class NumberValidationUtils {
    // 중복 값이 있는지 확인
    public static boolean isNotDuplication(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == numbers.size();
    }

    // n만큼의 길이인지 확인
    public static boolean isRequirementLength(List<Integer> numbers, int n) {
        return numbers.size() == n;
    }

    // 각 자리의 수가 1부터 9까지인지 확인
    public static boolean isItEachNumber(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 9);
    }

    // 사용자에게 입력 받을 시, 해당 문자열이 1부터 9까지 3자리 수인지 확인
    public static boolean validateThreeDigitRange1to9(String numbers) {
        return numbers.matches("^[1-9]{3}$");
    }
}
