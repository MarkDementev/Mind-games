package hexlet.code.games;

import hexlet.code.Engine;
import java.util.Scanner;

public class Progression {
    public static void progressionNewRound(String playerName) {
        int progressionLength = (int) (5 + Math.random() * 10);
        int emptyPlaceNumber = (int) (Math.random() * (progressionLength + 1));
        //String firstElementProgression = Engine.calcRandomNumber().toString();
        String[] progressionArray = new String[progressionLength];
        //progressionArray[0] = firstElementProgression.toString();


        Scanner progressionScanner = new Scanner(System.in);
        //System.out.println("Question: " + firstOutputElement + " " + secondOutputElement);
        System.out.print("Your answer: ");
        String playerAnswer = progressionScanner.next();
        //Engine.isCorrectAnswer(playerAnswer, correctAnswer, playerName);
    }
}
