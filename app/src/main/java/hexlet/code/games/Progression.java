package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;
import java.util.Arrays;

public class Progression {
    public static final String PROGRESSION_RULE = "What number is missing in the progression?";

    public static void playProgressionGame() {
        Engine.playerIntroduction();
        Engine.showGameRule(5);
        Engine.askQuestions(5);
    }

    public static String generateProgressionQuestion() {
        int arrLength = (int) (5 + Math.random() * 6);
        int emptyPlaceNumber = (int) (Math.random() * (arrLength - 1));
        int progressionStep = RandomUtils.generateRandomNumber();
        int firstElementProgression = RandomUtils.generateRandomNumber();
        String[] progressionArr = new String[arrLength];
        int[] intProgressionArr = new int[arrLength];

        for (int i1 = 0; i1 < arrLength; i1++) {
            intProgressionArr[i1] = firstElementProgression;
            firstElementProgression = firstElementProgression + progressionStep;
        }

        for (int i2 = 0; i2 < arrLength; i2++) {
            progressionArr[i2] = Integer.toString(intProgressionArr[i2]);
        }
        progressionArr[emptyPlaceNumber] = "..";
        return Arrays.toString(progressionArr)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");
    }

    public static String generateProgressionCorrectAnswer(String question) {
        String[] progressionAnswerArr = question.split(" ");
        int correctAnswerIndex = 0;
        int correctAnswer;
        int progressionStep;

        for (int i3 = 0; i3 < progressionAnswerArr.length; i3++) {
            if (progressionAnswerArr[i3].equals("..")) {
                correctAnswerIndex = i3;
            }
        }

        if (correctAnswerIndex == 0) {
            progressionStep = (Integer.parseInt(progressionAnswerArr[correctAnswerIndex + 2])
                    - Integer.parseInt(progressionAnswerArr[correctAnswerIndex + 1]));
            correctAnswer = Integer.parseInt(progressionAnswerArr[correctAnswerIndex + 1]) - progressionStep;
        } else if (correctAnswerIndex == progressionAnswerArr.length - 1) {
            progressionStep = (Integer.parseInt(progressionAnswerArr[correctAnswerIndex - 1])
                    - Integer.parseInt(progressionAnswerArr[correctAnswerIndex - 2]));
            correctAnswer = Integer.parseInt(progressionAnswerArr[correctAnswerIndex - 1]) + progressionStep;
        } else {
            progressionStep = (Integer.parseInt(progressionAnswerArr[correctAnswerIndex + 1])
                    - Integer.parseInt(progressionAnswerArr[correctAnswerIndex - 1])) / 2;
            correctAnswer = Integer.parseInt(progressionAnswerArr[correctAnswerIndex + 1]) - progressionStep;
        }
        return Integer.toString(correctAnswer);
    }
}
