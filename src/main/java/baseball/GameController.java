package baseball;

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
