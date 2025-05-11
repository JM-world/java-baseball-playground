package baseball.view;

public class InputView {

    public static void numberInputInfo() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void invalidNumberInfo() {
        System.out.println("유효하지 않은 값입니다.");
    }

    public static void restartInfo() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
