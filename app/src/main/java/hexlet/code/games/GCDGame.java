package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class GCDGame {
    public static final String GCD_RULE = "Find the greatest common divisor of given numbers.";
    private static final int GCD_LOWER_BORDER = 1;

    public static void startGCDGame() {
        String[][] questionAnswerPairs = new String[Engine.ROUND_COUNT][];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            questionAnswerPairs[i] = generateGCDQuestionAndAnswerPair();
        }
        Engine.runGame(GCD_RULE, questionAnswerPairs);
    }

    public static String[] generateGCDQuestionAndAnswerPair() {
        String[] questionAnswerPair = new String[2];
        int firstOutputElement = RandomUtils.generateRandomNumber(GCD_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER);
        int secondOutputElement = RandomUtils.generateRandomNumber(GCD_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER);

        questionAnswerPair[0] = firstOutputElement + " " + secondOutputElement;
        questionAnswerPair[1] = String.valueOf(findGCD(firstOutputElement, secondOutputElement));
        return questionAnswerPair;
    }

    static int findGCD(int firstOutputElement, int secondOutputElement) {
        if (secondOutputElement == 0) {
            return firstOutputElement;
        }
        return findGCD(secondOutputElement, firstOutputElement % secondOutputElement);
    }
}
