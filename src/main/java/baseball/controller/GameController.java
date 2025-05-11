package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.PlayResult;
import baseball.domain.RandomNumberGenerator;
import baseball.input.InputPlayerNumber;
import baseball.utils.ParseUtils;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    public void playGame() {
        boolean isRestart = true;

        while (isRestart) {
            isRestart = playOneGame();
        }
    }

    private boolean playOneGame() {
        Balls computerBalls = new Balls(RandomNumberGenerator.createNumbers());
        boolean keepGoing = true;

        while (keepGoing) {
            InputView.numberInputInfo();
            String playerNumber = InputPlayerNumber.inputNumber();
            Balls playerBalls = new Balls(ParseUtils.parseList(playerNumber));
            PlayResult play = computerBalls.play(playerBalls);
            OutputView.reportBalls(play);
            keepGoing = !play.isThreeStrike();
        }

        return InputPlayerNumber.isRestart();
    }
}
