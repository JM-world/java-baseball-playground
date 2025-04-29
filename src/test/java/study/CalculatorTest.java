package study;

import calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("정상적인 사칙연산 문자열을 입력하면 올바른 값을 반환")
    void calculateTest() {
        assertThat(Calculator.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
        assertThat(Calculator.calculate("20 - 2 / 9")).isEqualTo(2);
        assertThat(Calculator.calculate("10 + 2 + 4 * 2")).isEqualTo(32);
        assertThat(Calculator.calculate("8 / 2 + 2 * 2")).isEqualTo(12);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 / +", "   /  ", "a + 1", "+", "1+ 2", "1+2"})
    @DisplayName("숫자가 올바르지 않은 경우 예외 발생")
    void invalidNumberOrWordSpacingTest(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자가 아니거나 띄어쓰기가 잘못되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 ^ 4", "3 % 3", "3 3 3"})
    @DisplayName("사칙연산 기호가 올바르지 않은 경우 예외를 표시")
    void invalidOperatorOrWordSpacingTest(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효하지 않은 연산자이거나 띄어쓰기가 잘못되었습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @DisplayName("빈 문자열인 경우 예외를 표시")
    void nothingInputTest(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("빈 문자열입니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 / ", "2 - 1 1"})
    @DisplayName("계산식이 마무리되지 않은 경우")
    void wrongFormulaTest(String input) {
        assertThatThrownBy(() -> Calculator.calculate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("계산식이 완성되지 않았습니다.");
    }

    @Test
    @DisplayName("0으로 나누면 예외가 표시")
    void divideByZeroTest() {
        assertThatThrownBy(() -> Calculator.calculate("1 / 0"))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("0으로 나눌 수 없습니다.");
    }
}
