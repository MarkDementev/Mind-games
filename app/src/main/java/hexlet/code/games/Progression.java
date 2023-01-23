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
        int emptyPlaceNumber;

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            progressionArrayLength = RandomUtils.generateRandomNumber(PROGRESSION_MIN_SIZE, PROGRESSION_MAX_SIZE);
            progressionStep = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                    RandomUtils.DEFAULT_UPPER_BORDER);
            firstElement = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                    RandomUtils.DEFAULT_UPPER_BORDER);
            emptyPlaceNumber = RandomUtils.generateRandomNumber(0, progressionArrayLength - 1);
            int[] intRoundProgression = formProgression(progressionArrayLength, progressionStep, firstElement);
            String[] roundProgression = intProgressionToString(intRoundProgression, progressionArrayLength,
                    emptyPlaceNumber);
            questionAnswerPairs[i] = makeProgressionQuestionAndAnswerPair(roundProgression, progressionArrayLength,
                    progressionStep, emptyPlaceNumber);
        }
        Engine.runGame(PROGRESSION_RULE, questionAnswerPairs);
    }

    public static int[] formProgression(int progressionArrayLength, int progressionStep, int firstElement) {
        int[] intProgressionArray = new int[progressionArrayLength];

        for (int i = 0; i < progressionArrayLength; i++) {
            intProgressionArray[i] = firstElement;
            firstElement = firstElement + progressionStep;
        }
        return intProgressionArray;
    }

    public static String[] intProgressionToString(int[] intRoundProgression, int progressionArrayLength,
                                                  int emptyPlaceNumber) {
        String[] progressionArray = new String[progressionArrayLength];

        for (int i = 0; i < progressionArrayLength; i++) {
            progressionArray[i] = String.valueOf(intRoundProgression[i]);
        }
        progressionArray[emptyPlaceNumber] = EMPTY_PLACE_ELEMENT;
        return progressionArray;
    }

    public static String[] makeProgressionQuestionAndAnswerPair(String[] roundProgression, int progressionArrayLength,
                                                                int progressionStep, int emptyPlaceNumber) {
        String[] questionAnswerPair = new String[2];

        questionAnswerPair[0] = Arrays.toString(roundProgression)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");

        if (emptyPlaceNumber == progressionArrayLength - 1) {
            questionAnswerPair[1] = String.valueOf(Integer.
                    parseInt(roundProgression[emptyPlaceNumber - 1]) + progressionStep);
        } else {
            questionAnswerPair[1] = String.valueOf(Integer.
                    parseInt(roundProgression[emptyPlaceNumber + 1]) - progressionStep);
        }
        return questionAnswerPair;
    }
}
