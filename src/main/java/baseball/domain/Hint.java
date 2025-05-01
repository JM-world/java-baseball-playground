package baseball.domain;

public class Hint {
    private final int strike;
    private final int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public String getMessage() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike > 0) {
            sb.append(strike).append("스트라이크");
        }
        return sb.toString().trim();
    }
}
