package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Prime {
    public static final String PRIME_RULE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static void playPrimeGame() {
        Engine.playerIntroduction();
        Engine.showGameRule(6);
        Engine.askQuestions(6);
    }

    public static String generatePrimeQuestion() {
        return Integer.toString(RandomUtils.generateRandomNumber());
    }

    public static String generatePrimeCorrectAnswer(String question) {
        String correctAnswer = "no";
        int noOneDividerCounts = 0;

        for (int i = 2; i <= RandomUtils.getRandomNumberUpperBorder(); i++) {
            if (Integer.parseInt(question) % i == 0) {
                noOneDividerCounts++;
            }
        }

        if (Integer.parseInt(question) > 1 && noOneDividerCounts == 1) {
            correctAnswer = "yes";
        }
        return correctAnswer;
    }
}
