package hexlet.code.games;

import hexlet.code.utils.RandomUtils;

public class Prime {
    public static final String PRIME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int PRIME_UPPER_BORDER = 3571;
    //т.к. в Википедии дан список простых чисел до 3571, поставлю это число верх. границей

    public static void playPrimeGame() {
        GameDataToEnginePreparer.formQuestionsAnswersThenRunEngine("Prime", PRIME_RULE);
    }

    public static String generatePrimeQuestion() {
        return String.valueOf(RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER, PRIME_UPPER_BORDER));
    }

    public static String generatePrimeCorrectAnswer(String question) {
        return isPrimeNumber(question);
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
