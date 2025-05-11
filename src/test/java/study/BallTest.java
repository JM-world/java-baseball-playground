package study;

import baseball.domain.Ball;
import baseball.domain.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 작은 단위 테스트 -> 이후 BallsTest
public class BallTest {
    private Ball computerBall;

    @BeforeEach
    void setUp() {
        computerBall = new Ball(1, 1);
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크")
    void strike() {
        // 컴퓨터가 1번 위치에 1인 경우 -> 1, 1
        // 플레이어 1번 위치에 1인 경우 -> 1, 1
        // 결과: 스트라이크
        Ball userBall = new Ball(1, 1);
        BallStatus status = computerBall.play(userBall);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("다른 자리에 있으면 볼")
    void ball() {
        // 컴퓨터가 1번 위치에 1인 경우 -> 1, 1
        // 플레이어 2번 위치에 1인 경우 -> 2, 1
        // 결과: 볼
        Ball userBall = new Ball(2, 1);
        BallStatus status = computerBall.play(userBall);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("같은 수가 전혀 없으면 낫싱")
    void nothing() {
        // 컴퓨터가 1번 위치에 1인 경우 -> 1, 1
        // 플레이어 2번 위치에 2인 경우 -> 2, 2
        // 결과: 낫싱
        Ball userBall = new Ball(2, 2);
        BallStatus status = computerBall.play(userBall);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
