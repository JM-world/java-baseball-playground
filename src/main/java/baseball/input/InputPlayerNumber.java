package baseball.input;

import baseball.utils.NumberValidationUtils;
import baseball.view.InputView;

import java.util.Scanner;

public class InputPlayerNumber {

    public static String inputNumber() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (!NumberValidationUtils.playerNumberIsNotInvalid(input)) {
            InputView.invalidNumberInfo();
            InputView.numberInputInfo();
            return inputNumber();
        }

        return input;
    }

    public static boolean isRestart() {
        InputView.restartInfo();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (!NumberValidationUtils.validateDigitRange1or2(input)) {
            InputView.invalidNumberInfo();
            return isRestart();
        }

        return input.equals("1");
    }
}
