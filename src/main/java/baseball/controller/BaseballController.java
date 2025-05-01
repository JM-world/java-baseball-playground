package baseball.controller;

import baseball.domain.Hint;
import baseball.domain.NumberComparer;
import baseball.domain.Result;
import baseball.domain.SecretNumberCreator;
import baseball.input.InputReader;
import baseball.input.InputValidator;
import baseball.input.UserInput;
import baseball.view.InputView;

import java.util.List;

public class BaseballController {
    public static void main(String[] args) {
        boolean isRestart = true;

        while (isRestart) {
            isRestart = playOneGame();
        }
    }

    private static boolean playOneGame() {
        // 컴퓨터가 랜덤한 번호 생성
        List<Integer> computerNumber = SecretNumberCreator.create();
        // 3스트라이크 여부
        boolean isCorrect = false;

        while (!isCorrect) {
            // 유저에게 3자리 번호 입력받기
            List<Integer> userInput = UserInput.getUserInput();
            // 스트라이크, 볼 검증
            Hint hint = NumberComparer.compare(computerNumber, userInput);
            // 결과 안내
            isCorrect = Result.gameReport(hint);
        }

        return askRestart();
    }

    private static boolean askRestart() {
        InputView.reGameInfo();
        String input = InputReader.readLine();
        // 숫자 검증
        InputValidator.validateNextGameAll(input);
        return input.equals("1");
    }
}
