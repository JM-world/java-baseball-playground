package baseball.input;

import baseball.view.InputView;

import java.util.List;

import static baseball.utils.Parser.toIntegerList;

public class UserInput {

    public static List<Integer> getUserInput() {
        InputView.numberInputInfo();
        String input = InputReader.readLine();
        // 숫자 검증
        InputValidator.validateFirstGameAll(input);
        return toIntegerList(input);
    }
}
