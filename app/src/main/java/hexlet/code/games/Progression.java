package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Progression {
    public static final String PROGRESSION_RULE = "What number is missing in the progression?";
    private static final int PROGRESSION_MIN_SIZE = 5;
    private static final int PROGRESSION_MAX_SIZE = 10;
    private static final String EMPTY_PLACE_ELEMENT = "..";

    public static void startProgressionGame() {
        String[][] questionAnswerPairs = new String[Engine.ROUND_COUNT][];
        int progressionArrayLength;
        int progressionStep;
        int emptyPlaceNumber;
        int firstElement;

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            progressionArrayLength = RandomUtils.generateRandomNumber(PROGRESSION_MIN_SIZE, PROGRESSION_MAX_SIZE);
            progressionStep = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                    RandomUtils.DEFAULT_UPPER_BORDER);
            emptyPlaceNumber = RandomUtils.generateRandomNumber(0, progressionArrayLength - 1);
            firstElement = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                    RandomUtils.DEFAULT_UPPER_BORDER);
            questionAnswerPairs[i] = makeProgressionQuestionAndAnswerPair(progressionArrayLength,
                    progressionStep, emptyPlaceNumber, firstElement);
        }
        Engine.runGame(PROGRESSION_RULE, questionAnswerPairs);
    }

    public static String[] makeProgressionQuestionAndAnswerPair(int progressionArrayLength,
                                                                int progressionStep,
                                                                int emptyPlaceNumber, int firstElement) {
        String[] questionAnswerPair = new String[2];
        int[] intRoundProgression = formProgression(progressionArrayLength, progressionStep, firstElement);
        StringBuilder intToStringRoundProgression = new StringBuilder(progressionArrayLength);

        for (int i = 0; i < progressionArrayLength; i++) {
            if (i == emptyPlaceNumber) {
                intToStringRoundProgression.append(EMPTY_PLACE_ELEMENT);
            } else {
                intToStringRoundProgression.append(intRoundProgression[i]);
            }
            intToStringRoundProgression.append(" ");
        }
        questionAnswerPair[0] = intToStringRoundProgression.toString();

        if (emptyPlaceNumber == progressionArrayLength - 1) {
            questionAnswerPair[1] = String.valueOf(intRoundProgression[emptyPlaceNumber - 1] + progressionStep);
        } else {
            questionAnswerPair[1] = String.valueOf(intRoundProgression[emptyPlaceNumber + 1] - progressionStep);
        }
        return questionAnswerPair;
    }

    public static int[] formProgression(int progressionArrayLength, int progressionStep, int firstElement) {
        int[] intProgressionArray = new int[progressionArrayLength];

        for (int i = 0; i < progressionArrayLength; i++) {
            intProgressionArray[i] = firstElement;
            firstElement = firstElement + progressionStep;
        }
        return intProgressionArray;
    }
}
