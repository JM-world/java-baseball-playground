package study.baseball;

import baseball.domain.Hint;
import baseball.domain.NumberComparer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class NumberComparerTest {

    @ParameterizedTest
    @CsvSource({
            "123,123,3,0,3스트라이크",
            "123,132,1,2,2볼 1스트라이크",
            "123,456,0,0,낫싱",
            "123,124,2,0,2스트라이크",
            "123,312,0,3,3볼",
            "123,134,1,1,1볼 1스트라이크"
    })
    @DisplayName("컴퓨터 숫자와 사용자 입력을 비교해 볼/스트라이크 결과를 반환한다")
    void shouldReturnCorrectHint_whenComparingNumbers(
            String computerStr,
            String inputStr,
            int expectedStrike,
            int expectedBall,
            String expectedMessage
    ) {
        List<Integer> computer = toIntList(computerStr);
        List<Integer> input = toIntList(inputStr);

        Hint hint = NumberComparer.compare(computer, input);

        assertThat(hint.getMessage()).isEqualTo(expectedMessage);
        assertThat(hint.isThreeStrike()).isEqualTo(expectedStrike == 3);
    }

    private List<Integer> toIntList(String str) {
        return str.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }
}
