package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;
import java.util.Arrays;

public class Progression {
    public static final String PROGRESSION_RULE = "What number is missing in the progression?";
    private static final int PROGRESSION_MIN_SIZE = 5;
    private static final int PROGRESSION_MAX_SIZE = 10;
    private static final String EMPTY_PLACE_ELEMENT = "..";

    public static void startProgressionGame() {
        String[][] questionAnswerPairs = new String[Engine.ROUND_COUNT][];
        int progressionArrayLength;
        int progressionStep;
        int firstElement;

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            progressionArrayLength = RandomUtils.generateRandomNumber(PROGRESSION_MIN_SIZE, PROGRESSION_MAX_SIZE);
            firstElement = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                    RandomUtils.DEFAULT_UPPER_BORDER);
            progressionStep = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                    RandomUtils.DEFAULT_UPPER_BORDER);
            String[] roundProgression = formProgression(progressionArrayLength, progressionStep, firstElement);
            questionAnswerPairs[i] = makeProgressionQuestionAndAnswerPair(roundProgression);
        }
        Engine.runGame(PROGRESSION_RULE, questionAnswerPairs);
    }

    public static String[] formProgression(int progressionArrayLength, int progressionStep, int firstElement) {
        String[] progressionArray = new String[progressionArrayLength];
        int[] intProgressionArray = new int[progressionArrayLength];

        int emptyPlaceNumber = RandomUtils.generateRandomNumber(0, progressionArrayLength - 1);

        for (int i1 = 0; i1 < progressionArrayLength; i1++) {
            intProgressionArray[i1] = firstElement;
            firstElement = firstElement + progressionStep;
        }

        for (int i2 = 0; i2 < progressionArrayLength; i2++) {
            progressionArray[i2] = String.valueOf(intProgressionArray[i2]);
        }
        progressionArray[emptyPlaceNumber] = EMPTY_PLACE_ELEMENT;
        return progressionArray;
    }

    public static String[] makeProgressionQuestionAndAnswerPair(String[] roundProgression) {
        String[] questionAnswerPair = new String[2];
        int correctAnswerIndex = 0;
        int progressionStep;

        questionAnswerPair[0] = Arrays.toString(roundProgression)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");

        for (int i3 = 0; i3 < roundProgression.length; i3++) {
            if (roundProgression[i3].equals(EMPTY_PLACE_ELEMENT)) {
                correctAnswerIndex = i3;
            }
        }
        progressionStep = findProgressionStep(correctAnswerIndex, roundProgression);

        if (correctAnswerIndex == roundProgression.length - 1) {
            questionAnswerPair[1] = String.valueOf(Integer.
                    parseInt(roundProgression[correctAnswerIndex - 1]) + progressionStep);
        } else {
            questionAnswerPair[1] = String.valueOf(Integer.
                    parseInt(roundProgression[correctAnswerIndex + 1]) - progressionStep);
        }
        return questionAnswerPair;
    }

    private static int findProgressionStep(int correctAnswerIndex, String[] progressionAnswerArr) {
        int finalArrElementIndex = progressionAnswerArr.length - 1;

        if (correctAnswerIndex == 0 || correctAnswerIndex == finalArrElementIndex) {
            return Integer.parseInt(progressionAnswerArr[finalArrElementIndex - 1])
                    - Integer.parseInt(progressionAnswerArr[finalArrElementIndex - 2]);
        } else {
            return (Integer.parseInt(progressionAnswerArr[finalArrElementIndex])
                    - Integer.parseInt(progressionAnswerArr[0]))
                    / (finalArrElementIndex);
        }
    }
}
