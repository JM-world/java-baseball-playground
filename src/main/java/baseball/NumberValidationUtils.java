package baseball;

import java.util.HashSet;
import java.util.List;

public class NumberValidationUtils {

    // (플레이어) 입력 값 검증
    public static boolean playerNumberIsNotInvalid(String numbers) {
        return validateThreeDigitRange1to9(numbers) && isNotDuplicationOfPlayer(numbers);
    }

    // (컴퓨터) 입력 값 검증
    public static boolean computerNumberIsNotInvalid(List<Integer> numbers) {
        return isNotDuplication(numbers)
                && isRequirementLength(numbers)
                && isItEachNumber(numbers);
    }

    // (컴퓨터 수 검증) 중복 값이 있는지 확인
    public static boolean isNotDuplication(List<Integer> numbers) {
        return new HashSet<>(numbers).size() == numbers.size();
    }

    // (컴퓨터 수 검증) n 만큼의 길이인지 확인
    public static boolean isRequirementLength(List<Integer> numbers) {
        return numbers.size() == DigitConstants.NUMBER_SIZE;
    }

    // (컴퓨터 수 검증) 각 자리의 수가 1부터 9까지인지 확인
    public static boolean isItEachNumber(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number >= 1 && number <= 9);
    }

    // (플레이어 검증) 해당 값들이 1부터 9까지 3자리 수인지 확인
    public static boolean validateThreeDigitRange1to9(String numbers) {
        return numbers.matches("^[1-9]{3}$");
    }

    // (플레이어 검증) 중복 값이 있는지 확인
    public static boolean isNotDuplicationOfPlayer(String numbers) {
        return numbers.chars()
                .distinct()
                .count() == numbers.length();
    }
}
