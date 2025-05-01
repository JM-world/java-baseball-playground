package study.baseball;

import baseball.input.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    @DisplayName("정상적인 3자리 입력은 예외가 발생하지 않아야 한다")
    void shouldNotThrowException_whenValidInput(String input) {
        assertDoesNotThrow(() -> InputValidator.validateFirstGameAll(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "133", "919"})
    @DisplayName("중복 숫자가 포함된 입력은 예외를 발생시킨다")
    void shouldThrowException_whenInputHasDuplicateDigits(String input) {
        assertThatThrownBy(() -> InputValidator.validateFirstGameAll(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 3자리 수");
    }

    @ParameterizedTest
    @ValueSource(strings = {"023", "103", "340"})
    @DisplayName("입력에 0이 포함된 경우 예외가 발생한다")
    void shouldThrowException_whenInputContainsZero(String input) {
        assertThatThrownBy(() -> InputValidator.validateFirstGameAll(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0은 포함될 수 없습니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"12", "abcd", "1234"})
    @DisplayName("3자리 숫자가 아닌 입력은 예외가 발생한다")
    void shouldThrowException_whenInputIsNotThreeDigitNumber(String input) {
        assertThatThrownBy(() -> InputValidator.validateFirstGameAll(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자리의 숫자가 아닙니다");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    @DisplayName("게임 재시작 입력값이 1 또는 2일 경우 예외가 발생하지 않는다")
    void shouldNotThrowException_whenValidRestartInput(String input) {
        assertDoesNotThrow(() -> InputValidator.validateNextGameAll(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3", "111", "a"})
    @DisplayName("게임 재시작 입력값이 1 또는 2가 아닐 경우 예외가 발생한다")
    void shouldThrowException_whenRestartInputIsInvalid(String input) {
        assertThatThrownBy(() -> InputValidator.validateNextGameAll(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1 또는 2");
    }
}
