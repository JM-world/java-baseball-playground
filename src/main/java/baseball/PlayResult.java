package baseball;

public class PlayResult {

    private int strike;
    private int ball;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void report(BallStatus status) {
        if (status.isStrike()) {
            strike++;
        }

        if (status.isBall()) {
            ball++;
        }
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public String getMessage() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        if (isThreeStrike()) {
            return "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }

        StringBuilder sb = new StringBuilder();
        if (strike > 0) {
            sb.append(strike).append(" 스트라이크 ");
        }
        if (ball > 0) {
            sb.append(ball).append(" 볼");
        }

        return sb.toString().trim();
    }
}
