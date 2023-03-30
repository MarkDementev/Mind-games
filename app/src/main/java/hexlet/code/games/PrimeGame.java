package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class PrimeGame {
    public static final String PRIME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int PRIME_UPPER_BORDER = 3571;

    public static void startPrimeGame() {
        String[][] questionAnswerPairs = new String[Engine.ROUND_COUNT][];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            questionAnswerPairs[i] = generatePrimeQuestionAndAnswerPair();
        }
        Engine.runGame(PRIME_RULE, questionAnswerPairs);
    }

    public static String[] generatePrimeQuestionAndAnswerPair() {
        String[] questionAnswerPair = new String[2];

        questionAnswerPair[0] = String.valueOf(RandomUtils.
                generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER, PRIME_UPPER_BORDER));
        questionAnswerPair[1] = isPrimeNumber(Integer.parseInt(questionAnswerPair[0])) ? "yes" : "no";
        return questionAnswerPair;
    }

    public static boolean isPrimeNumber(int inputNumber) {
        if (inputNumber < 2) {
            return false;
        }
        int noOneDividerCounts = 0;

        for (int i = 2; i <= PRIME_UPPER_BORDER; i++) {
            if (inputNumber % i == 0) {
                noOneDividerCounts++;
            }
        }
        return noOneDividerCounts == 1;
    }
}
