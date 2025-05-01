package baseball.domain;

import baseball.utils.PrintUtil;
import baseball.view.ResultView;

public class Result {
    public static boolean gameReport(Hint hint) {
        // 게임 결과
        PrintUtil.println(hint.getMessage());
        // 3스트라이크 여부
        if (hint.isThreeStrike()) {
            ResultView.isCorrect();
            return true;
        }

        return false;
    }
}
