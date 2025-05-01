package baseball.input;

public class InputValidator {

    // 중복된 숫자가 없는지 확인한다.
    private static void validateNoDuplicate(String input) {
        char a = input.charAt(0);
        char b = input.charAt(1);
        char c = input.charAt(2);
        if (a == b || a == c || b == c) {
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력해야합니다.");
        }
    }

    // 0이 포함되어 있지 않은지 확인한다.
    private static void validateNoContainsZero(String input) {
        if (input.contains("0")) {
            throw new IllegalArgumentException("0은 포함될 수 없습니다.");
        }
    }

    // 숫자 외의 문자가 포함되어 있지 않은지, N자리 숫자인지 확인한다.
    private static void validateNoStringAndLength(String input, int length) {
        if (!input.matches("\\d{" + length +  "}")) {
            throw new IllegalArgumentException(length + "자리의 숫자가 아닙니다.");
        }
    }

    public static void validateAll(String input) {
        validateNoStringAndLength(input);
        validateNoContainsZero(input);
        validateNoDuplicate(input);
    }
}
