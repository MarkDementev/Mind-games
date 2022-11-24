package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;

public class Engine {
    public static void playGame(String playerName, int gameType) {
        final int ROUND_COUNT = 3;

        switch (gameType) {
            case 2:
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                break;
            case 3:
                System.out.println("What is the result of the expression?");
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
                case 4:
                    GCD.calcNewRound(playerName);
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
