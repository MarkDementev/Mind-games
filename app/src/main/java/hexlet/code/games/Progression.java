package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;
import java.util.Arrays;

public class Progression {
    public static final int PROGRESSION_GAME_SEQUENCE_NUMBER = 5;
    public static final String PROGRESSION_RULE = "What number is missing in the progression?";
    private static final int PROGRESSION_MIN_SIZE = 5;

    public static void playProgressionGame() {
        Engine.playerIntroduction();
        Engine.showGameRule(PROGRESSION_GAME_SEQUENCE_NUMBER);
        Engine.askQuestionsToEnd(PROGRESSION_GAME_SEQUENCE_NUMBER);
    }

    public static String generateProgressionQuestion() {
        int arrLength = (int) (PROGRESSION_MIN_SIZE + Math.random() * (PROGRESSION_MIN_SIZE + 1));
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

        for (int i3 = 0; i3 < progressionAnswerArr.length; i3++) {
            if (progressionAnswerArr[i3].equals("..")) {
                correctAnswerIndex = i3;
            }
        }

        if (correctAnswerIndex == 0 || correctAnswerIndex == progressionAnswerArr.length - 1) {
            // Т к по условию не менее 5 эл-в в массиве, всегда будут 3 и 4 эл-ты
            correctAnswer = Integer.parseInt(progressionAnswerArr[3]) - Integer.parseInt(progressionAnswerArr[2]);
        } else {
            // т к не знаем, где пустой, из последнего эл-та вычтем первый и поделим на (их число - 1)
            correctAnswer = Integer.parseInt(progressionAnswerArr[progressionAnswerArr.length - 1])
                    - Integer.parseInt(progressionAnswerArr[0])
                    / progressionAnswerArr.length - 1;
        }
        return Integer.toString(correctAnswer);
    }
}
