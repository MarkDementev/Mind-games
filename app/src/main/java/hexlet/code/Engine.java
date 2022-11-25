package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class Engine {
        public final static int RANDOM_NUMBER_UPPER_BORDER = 101;
        public final static int ROUND_COUNT = 3;
    public static void makeStartRoundsFinalize(String playerName, int gameType) {
        switch (gameType) {
            case 2:
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                break;
            case 3:
                System.out.println("What is the result of the expression?");
                break;
            case 4:
                System.out.println("Find the greatest common divisor of given numbers.");
                break;
            case 5:
                System.out.println("What number is missing in the progression?");
                break;
            default:
                System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
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
                    break;
                case 5:
                    Progression.progressionNewRound(playerName);
                    break;
                default:
                    Prime.primeNewRound(playerName);
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static int calcRandomNumber() {
        return (int) (Math.random() * Engine.RANDOM_NUMBER_UPPER_BORDER);
    }

    public static void isCorrectAnswer(String playerAnswer, String correctAnswer, String playerName) {
        if (playerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + playerAnswer + "'"
                    + " is wrong answer ;(. Correct answer was"
                    + " '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + playerName + "!");
            System.exit(0);
        }
    }
}
