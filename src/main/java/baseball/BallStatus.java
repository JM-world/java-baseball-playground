package baseball;

public enum BallStatus {
    BALL, NOTHING, STRIKE;

    public boolean isNotNothing() {
        return this != NOTHING;
    }
}
