package baseball.view;

import baseball.utils.PrintUtil;

public class InputView {
    public static void numberInputInfo() {
        PrintUtil.print("숫자를 입력해 주세요 : ");
    }

    public static void reGameInfo() {
        PrintUtil.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
