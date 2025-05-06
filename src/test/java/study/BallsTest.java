package study;

import baseball.Ball;
import baseball.BallStatus;
import baseball.Balls;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    @Test
    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크")
    void strike() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(1, 1);
        BallStatus status = computerBalls.play(userBall);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("다른 자리에 있으면 볼")
    void ball() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(1, 2);
        BallStatus status = computerBalls.play(userBall);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("같은 수가 전혀 없으면 낫싱")
    void nothing() {
        Balls computerBalls = new Balls(Arrays.asList(1, 2, 3));
        Ball userBall = new Ball(1, 4);
        BallStatus status = computerBalls.play(userBall);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
