package calculator;

public class Calculator {

    public static int calculate(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열입니다.");
        }

        String[] values = input.trim().split(" ");

        int result = 0;
        String operator = "";

        // 연산자가 올 순서인지 확인
        boolean isOperatorSequence = true;

        for (int i = 0; i < values.length; i++) {
            String val = values[i];

            if (i == 0) {
                result = parseInt(values[i]);
                continue;
            }

            if (isOperatorSequence) {
                operator = val;
                isOperatorSequence = false;
                continue;
            }

            int number = parseInt(val);
            result = applyOperator(result, number, operator);
            isOperatorSequence = true;
        }

        // 계산식의 완성되지 않은 경우 ("1 + ", "1 + 2 3")
        if (!isOperatorSequence) {
            throw new IllegalArgumentException("계산식이 완성되지 않았습니다.");
        }

        return result;
    }

    // 연산
    private static int applyOperator(int result, int number, String operator) {
        switch (operator) {
            case "+": return result + number;
            case "-": return result - number;
            case "*": return result * number;
            case "/": {
                if (number == 0) {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                return result / number;
            }
            default: throw new IllegalArgumentException("유효하지 않은 연산자이거나 띄어쓰기가 잘못되었습니다.");
        }
    }

    // 정수 변환
    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아니거나 띄어쓰기가 잘못되었습니다.");
        }
    }
}
