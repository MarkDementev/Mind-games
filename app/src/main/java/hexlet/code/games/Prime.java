package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Prime {
    public static void primeNewRound(String playerName) {
        int outputNumber = Engine.calcRandomNumber();
        String correctAnswer;
        int noOneDividerCounts = 0;

        for (int i = 2; i <= Engine.RANDOM_NUMBER_UPPER_BORDER; i++) {
            if (outputNumber % i == 0) {
                noOneDividerCounts++;
            }
        }

        if (outputNumber > 1 && noOneDividerCounts == 1) {
            correctAnswer = "yes";
        } else {
            correctAnswer = "no";
        }

        Scanner primeScanner = new Scanner(System.in);
        System.out.println("Question: " + outputNumber);
        System.out.print("Your answer: ");
        String playerAnswer = primeScanner.next();
        Engine.isCorrectAnswer(playerAnswer, correctAnswer, playerName);
    }
}
