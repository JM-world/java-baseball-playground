package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> inputs) {
        this.balls = mapBalls(inputs);
    }

    private static List<Ball> mapBalls(List<Integer> inputs) {
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, inputs.get(i)));
        }
        return balls;
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(computerBall -> computerBall.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(Balls userBalls) {
        PlayResult result = new PlayResult();
        for (int i = 0; i < 3; i++) {
            BallStatus status = userBalls.play(balls.get(i));
            result.report(status);
        }
        return result;
    }
}
