package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;

public class Engine {
    public static void makeStartRoundsFinalize(String playerName, int gameType) {
        final int ROUND_COUNT = 3;

        switch (gameType) {
            case 2:
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                break;
            case 3:
                System.out.println("What is the result of the expression?");
                break;
            case 4:
                System.out.println("Find the greatest common divisor of given numbers.");
        }

        for (int correctAnswersCount = 0; correctAnswersCount < ROUND_COUNT; correctAnswersCount++) {
            switch (gameType) {
                case 2:
                    Even.evenNewRound(playerName);
                    break;
                case 3:
                    Calc.calcNewRound(playerName);
                    break;
                case 4:
                    GCD.gCDNewRound(playerName);
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static int calcRandomNumber() {
        final int RANDOM_NUMBER_UPPER_BORDER = 101;

        return (int) (Math.random() * RANDOM_NUMBER_UPPER_BORDER);
    }

    public static void informAboutWrongAnswer(String playerAnswer, String correctAnswer, String playerName) {
        System.out.println("'" + playerAnswer + "'"
                + " is wrong answer ;(. Correct answer was"
                + " '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + playerName + "!");
        System.exit(0);
    }
}
