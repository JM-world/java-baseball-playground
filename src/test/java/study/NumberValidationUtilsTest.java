package study;

import baseball.Balls;
import baseball.DigitConstants;
import baseball.NumberValidationUtils;
import baseball.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberValidationUtilsTest {

    @Test
    @DisplayName("컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 생성")
    void computerNumber() {
        List<Integer> numbers = RandomNumberGenerator.createNumbers();
        assertThat(NumberValidationUtils.isNotDuplication(numbers)).isTrue();
        assertThat(NumberValidationUtils.isRequirementLength(numbers, DigitConstants.NUMBER_SIZE)).isTrue();
        assertThat(NumberValidationUtils.isItEachNumber(numbers)).isTrue();
    }

    @Test
    @DisplayName("중복 검증1")
    void 중복이_없으면_true() {
        assertThat(NumberValidationUtils.isNotDuplication(Arrays.asList(1, 2, 3))).isTrue();
    }

    @Test
    @DisplayName("중복 검증2")
    void 중복이_있으면_false() {
        assertThat(NumberValidationUtils.isNotDuplication(Arrays.asList(1, 1, 2))).isFalse();
    }

    @Test
    @DisplayName("중복 검증3")
    void 빈_리스트는_true() {
        assertThat(NumberValidationUtils.isNotDuplication(new ArrayList<>())).isTrue();
    }

    @Test
    @DisplayName("길이 검증1")
    void 길이가_요구사항숫자_3이면_true() {
        assertThat(NumberValidationUtils.isRequirementLength(
                Arrays.asList(1, 2, 3),
                DigitConstants.NUMBER_SIZE)
        ).isTrue();
    }

    @Test
    @DisplayName("길이 검증2")
    void 길이가_요구사항숫자_3이_아니면_false() {
        // 3보다 짧은 길이인 경우
        assertThat(NumberValidationUtils.isRequirementLength(
                Arrays.asList(1, 2),
                DigitConstants.NUMBER_SIZE)
        ).isFalse();
        // 3보다 긴 길이인 경우
        assertThat(NumberValidationUtils.isRequirementLength(
                Arrays.asList(1, 2, 3, 4),
                DigitConstants.NUMBER_SIZE)
        ).isFalse();
    }

    @Test
    @DisplayName("숫자 범위 검증1")
    void 각_숫자의_범위가_1부터_9사이라면_true() {
        assertThat(NumberValidationUtils.isItEachNumber(Arrays.asList(1, 5, 9))).isTrue();
    }

    @Test
    @DisplayName("숫자 범위 검증2")
    void 각_숫자의_범위가_1부터_9사이가_아닌경우_false() {
        assertThat(NumberValidationUtils.isItEachNumber(Arrays.asList(-1, 5, 10))).isFalse();
    }
}
