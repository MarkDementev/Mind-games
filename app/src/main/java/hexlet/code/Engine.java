package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;

public class Engine {
    public static void playGame(String playerName, int gameType) {
        final int ROUND_COUNT = 3;

        switch (gameType) {
            case 2:
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                break;
            case 3:
                System.out.println("What is the result of the expression?");
        }

        for (int correctAnswersCount = 0; correctAnswersCount < ROUND_COUNT; correctAnswersCount++) {
            switch (gameType) {
                case 2:
                    Even.evenNewRound(playerName);
                    break;
                case 3:
                    Calc.calcNewRound(playerName);
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
