package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomUtils;

public class Prime {
    public static final String PRIME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int PRIME_UPPER_BORDER = 3571;
    //т.к. в Википедии дан список простых чисел до 3571, поставлю это число верх. границей

    public static void startPrimeGame() {
        String[][] primeQuestionsAnswers = new String[Engine.ROUND_COUNT][];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            primeQuestionsAnswers[i] = generatePrimeQuestionAndAnswerPair();
        }
        Engine.runGame(PRIME_RULE, primeQuestionsAnswers);
    }

    public static String[] generatePrimeQuestionAndAnswerPair() {
        String[] questionAnswerPair = new String[2];

        questionAnswerPair[0] = String.valueOf(RandomUtils.
                generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER, PRIME_UPPER_BORDER));
        questionAnswerPair[1] = isPrimeNumber(questionAnswerPair[0]);
        return questionAnswerPair;
    }

    public static String isPrimeNumber(String inputNumber) {
        String correctAnswer = "no";
        int noOneDividerCounts = 0;

        for (int i = 2; i <= PRIME_UPPER_BORDER; i++) {
            if (Integer.parseInt(inputNumber) % i == 0) {
                noOneDividerCounts++;
            }
        }

        if (Integer.parseInt(inputNumber) > 1 && noOneDividerCounts == 1) {
            correctAnswer = "yes";
        }
        return correctAnswer;
    }
}
