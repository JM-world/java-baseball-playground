package study.baseball;

import baseball.domain.Hint;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class HintTest {

    @ParameterizedTest
    @CsvSource({
            "3,0,true,3스트라이크",
            "2,1,false,1볼 2스트라이크",
            "0,3,false,3볼",
            "1,0,false,1스트라이크",
            "0,0,false,낫싱"
    })
    @DisplayName("볼과 스트라이크 개수에 따라 힌트 메시지와 3스트라이크 여부를 판단한다")
    void shouldReturnCorrectMessageAndStrikeStatus(
            int strike,
            int ball,
            boolean expectedThreeStrike,
            String expectedMessage
    ) {
        Hint hint = new Hint(strike, ball);
        assertThat(hint.getMessage()).isEqualTo(expectedMessage);
        assertThat(hint.isThreeStrike()).isEqualTo(expectedThreeStrike);
    }
}
