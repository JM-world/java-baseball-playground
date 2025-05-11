package study;

import baseball.Ball;
import baseball.BallStatus;
import baseball.Balls;
import baseball.PlayResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {

    private Balls computerBalls;

    @BeforeEach
    void setUp() {
        computerBalls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("3스트라이크 테스트")
    void play_3strike() {
        Balls userBalls = new Balls(Arrays.asList(1, 2, 3));
        PlayResult result = computerBalls.play(userBalls);
        assertThat(result.isThreeStrike()).isTrue();
    }

    @Test
    @DisplayName("1스트라이크 1볼 테스트")
    void play_1strike_1ball() {
        Balls userBalls = new Balls(Arrays.asList(1, 3, 4));
        PlayResult result = computerBalls.play(userBalls);
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);
    }

    @Test
    @DisplayName("낫싱 테스트")
    void play_nothing() {
        Balls userBalls = new Balls(Arrays.asList(4, 5, 6));
        PlayResult result = computerBalls.play(userBalls);
        assertThat(result.getStrike()).isEqualTo(0);
        assertThat(result.getBall()).isEqualTo(0);
    }

    @Test
    @DisplayName("같은 수가 같은 자리에 있으면 스트라이크")
    void strike() {
        Ball userBall = new Ball(1, 1);
        BallStatus status = computerBalls.play(userBall);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("다른 자리에 있으면 볼")
    void ball() {
        Ball userBall = new Ball(1, 2);
        BallStatus status = computerBalls.play(userBall);
        assertThat(status).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("같은 수가 전혀 없으면 낫싱")
    void nothing() {
        Ball userBall = new Ball(1, 4);
        BallStatus status = computerBalls.play(userBall);
        assertThat(status).isEqualTo(BallStatus.NOTHING);
    }
}
