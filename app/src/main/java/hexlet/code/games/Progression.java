package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Arrays;
import java.util.Scanner;

public class Progression {
    public static void progressionNewRound(String playerName) {
        int arrLength = (int) (5 + Math.random() * 6);
        int emptyPlaceNumber = (int) (Math.random() * (arrLength - 1));
        int progressionStep = Engine.calcRandomNumber();
        int firstElementProgression = Engine.calcRandomNumber();
        String[] progressionArr = new String[arrLength];
        int[] intProgressionArr = new int[arrLength];
        String correctAnswer;

        for (int i1 = 0; i1 < arrLength; i1++) {
            intProgressionArr[i1] = firstElementProgression;
            firstElementProgression = firstElementProgression + progressionStep;
        }

        for (int i2 = 0; i2 < arrLength; i2++) {
            progressionArr[i2] = Integer.toString(intProgressionArr[i2]);
        }
        progressionArr[emptyPlaceNumber] = "..";
        correctAnswer = Integer.toString(intProgressionArr[emptyPlaceNumber]);

        Scanner progressionScanner = new Scanner(System.in);
        System.out.println("Question: " + Arrays.toString(progressionArr)
                .replace(",", "")
                .replace("[", "")
                .replace("]", ""));
        System.out.print("Your answer: ");
        String playerAnswer = progressionScanner.next();
        Engine.isCorrectAnswer(playerAnswer, correctAnswer, playerName);
    }
}
