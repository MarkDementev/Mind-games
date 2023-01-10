package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomUtils;
import java.util.Arrays;

public class Progression {
    public static final String PROGRESSION_RULE = "What number is missing in the progression?";
    private static final int PROGRESSION_MIN_SIZE = 5;
    private static final int PROGRESSION_MAX_SIZE = 10;

    public static void startProgressionGameThenEngine() {
        String[][] progressionQuestionsAnswers = new String[Engine.ROUND_COUNT][];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            String[] roundProgression = formProgression();
            progressionQuestionsAnswers[i] = makeProgressionQuestionAndAnswerPair(roundProgression);
        }
        Engine.runGame(PROGRESSION_RULE, progressionQuestionsAnswers);
    }

    public static String[] formProgression() {
        int arrLength = RandomUtils.generateRandomNumber(PROGRESSION_MIN_SIZE, PROGRESSION_MAX_SIZE);
        int emptyPlaceNumber = RandomUtils.generateRandomNumber(0, arrLength - 1);
        int progressionStep = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER);
        int firstElementProgression = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER);
        String[] progressionArr = new String[arrLength];
        int[] intProgressionArr = new int[arrLength];

        for (int i1 = 0; i1 < arrLength; i1++) {
            intProgressionArr[i1] = firstElementProgression;
            firstElementProgression = firstElementProgression + progressionStep;
        }

        for (int i2 = 0; i2 < arrLength; i2++) {
            progressionArr[i2] = String.valueOf(intProgressionArr[i2]);
        }
        progressionArr[emptyPlaceNumber] = "..";
        return progressionArr;
    }

    public static String[] makeProgressionQuestionAndAnswerPair(String[] roundProgression) {
        String[] questionAnswerPair = new String[2];
        int correctAnswerIndex = 0;
        int progressionStep = 0;

        questionAnswerPair[0] = Arrays.toString(roundProgression)
                .replace(",", "")
                .replace("[", "")
                .replace("]", "");

        for (int i3 = 0; i3 < roundProgression.length; i3++) {
            if (roundProgression[i3].equals("..")) {
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

/*    public static String generateProgressionCorrectAnswer(String question) {
        String[] progressionAnswerArr = question.split(" ");
        int correctAnswerIndex = 0;
        int progressionStep;

        for (int i3 = 0; i3 < progressionAnswerArr.length; i3++) {
            if (progressionAnswerArr[i3].equals("..")) {
                correctAnswerIndex = i3;
            }
        }
        progressionStep = findProgressionStep(correctAnswerIndex, progressionAnswerArr);

        if (correctAnswerIndex == progressionAnswerArr.length - 1) {
            return String.valueOf(Integer.parseInt(progressionAnswerArr[correctAnswerIndex - 1]) + progressionStep);
        } else {
            return String.valueOf(Integer.parseInt(progressionAnswerArr[correctAnswerIndex + 1]) - progressionStep);
        }
    }*/
}
