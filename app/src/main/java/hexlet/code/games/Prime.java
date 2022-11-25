package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Scanner;

public class Prime {
    public static void primeNewRound(String playerName) {
        int outputNumber = Engine.calcRandomNumber();
        String correctAnswer;

        if () {
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
