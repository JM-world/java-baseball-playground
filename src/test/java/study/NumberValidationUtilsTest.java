package study;

import baseball.NumberValidationUtils;
import baseball.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberValidationUtilsTest {

    // 플레이어 입력값 검증 전체
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    @DisplayName("플레이어는 1에서 9까지 서로 다른 임의의 수 3개를 입력")
    void playerNumber(String playerNumber) {
        // 플레이어 검증 전체 메소드
        assertThat(NumberValidationUtils.playerNumberIsNotInvalid(playerNumber)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    @DisplayName("플레이어 입력값 범위 및 자리수 검증1")
    void 각_숫자가_1부터_9사이이고_3자리이면_true(String playerNumber) {
        assertThat(NumberValidationUtils.validateThreeDigitRange1to9(playerNumber)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a23", "1234", "12", "023", "", " "})
    @DisplayName("플레이어 입력값 중복 검증2")
    void 숫자가_1부터_9사이가_아니거나_3자리가_아니면_false(String playerNumber) {
        assertThat(NumberValidationUtils.validateThreeDigitRange1to9(playerNumber)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    @DisplayName("플레이어 입력값 중복 검증1")
    void 중복이_없으면_true(String playerNumber) {
        assertThat(NumberValidationUtils.isNotDuplicationOfPlayer(playerNumber)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "122"})
    @DisplayName("플레이어 입력값 중복 검증2")
    void 중복이_있으면_false(String playerNumber) {
        assertThat(NumberValidationUtils.isNotDuplicationOfPlayer(playerNumber)).isFalse();
    }

    // 컴퓨터 랜덤값 검증 전체
    @Test
    @DisplayName("컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 생성")
    void computerNumber() {
        List<Integer> numbers = RandomNumberGenerator.createNumbers();
        // 컴퓨터 검증 전체 메소드
        assertThat(NumberValidationUtils.computerNumberIsNotInvalid(numbers)).isTrue();
    }

    @Test
    @DisplayName("컴퓨터 랜덤 값 중복 검증1")
    void 중복이_없으면_true() {
        assertThat(NumberValidationUtils.isNotDuplication(Arrays.asList(1, 2, 3))).isTrue();
    }

    @Test
    @DisplayName("컴퓨터 랜덤 값 중복 검증2")
    void 중복이_있으면_false() {
        assertThat(NumberValidationUtils.isNotDuplication(Arrays.asList(1, 1, 2))).isFalse();
    }

    @Test
    @DisplayName("컴퓨터 랜덤 값 중복 검증3")
    void 빈_리스트는_true() {
        assertThat(NumberValidationUtils.isNotDuplication(new ArrayList<>())).isTrue();
    }

    @Test
    @DisplayName("컴퓨터 랜덤 값 길이 검증1")
    void 길이가_요구사항숫자_3이면_true() {
        assertThat(NumberValidationUtils.isRequirementLength(Arrays.asList(1, 2, 3))).isTrue();
    }

    @Test
    @DisplayName("컴퓨터 랜덤 값 길이 검증2")
    void 길이가_요구사항숫자_3이_아니면_false() {
        // 3보다 짧은 길이인 경우
        assertThat(NumberValidationUtils.isRequirementLength(Arrays.asList(1, 2))).isFalse();
        // 3보다 긴 길이인 경우
        assertThat(NumberValidationUtils.isRequirementLength(Arrays.asList(1, 2, 3, 4))).isFalse();
    }

    @Test
    @DisplayName("컴퓨터 랜덤 값 숫자 범위 검증1")
    void 각_숫자의_범위가_1부터_9사이라면_true() {
        assertThat(NumberValidationUtils.isItEachNumber(Arrays.asList(1, 5, 9))).isTrue();
    }

    @Test
    @DisplayName("컴퓨터 랜덤 값 숫자 범위 검증2")
    void 각_숫자의_범위가_1부터_9사이가_아닌경우_false() {
        assertThat(NumberValidationUtils.isItEachNumber(Arrays.asList(-1, 5, 10))).isFalse();
    }
}
