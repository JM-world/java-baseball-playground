package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void split2() {
        String[] actual = "1".split(",");
        assertThat(actual).contains("1");
    }

    @Test
    void substring() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("문자열 'abc'의 인덱스 0, 1, 2 위치의 문자 가져오기")
    void charAtSuccess() {
        String actual = "abc";
        assertThat('a').isEqualTo(actual.charAt(0));
        assertThat('b').isEqualTo(actual.charAt(1));
        assertThat('c').isEqualTo(actual.charAt(2));
    }

    @Test
    @DisplayName("문자열 'ab'에서 인덱스 2에 접근하면 StringIndexOutOfBoundsException이 발생")
    void charAtFailure() {
        String actual = "ab";

        assertThatThrownBy(() -> {
            actual.charAt(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 2");

        // 다른 방법
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    actual.charAt(2);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
