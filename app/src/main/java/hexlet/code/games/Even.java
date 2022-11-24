package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Even {
    public static void evenNewRound(String playerName) {
        int outputNumber = Engine.calcRandomNumber();
        String correctAnswer = "no";

        if (outputNumber % 2 == 0) {
            correctAnswer = "yes";
        }

        Scanner isEvenScanner = new Scanner(System.in);
        System.out.println("Question: " + outputNumber);
        System.out.print("Your answer: ");
        String playerAnswer = isEvenScanner.next();
        Engine.isCorrectAnswer(playerAnswer, correctAnswer, playerName);
    }
}
