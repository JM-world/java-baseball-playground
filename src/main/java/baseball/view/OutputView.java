package baseball.view;

import baseball.domain.PlayResult;

public class OutputView {

    public static void reportBalls(PlayResult result) {
        System.out.println(result.getMessage());
    }
}
