package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Even {
    public static final String EVEN_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static void playEvenGame() {
        String[] evenGameQuestions = new String[Engine.ROUND_COUNT];
        String[] evenGameCorrectAnswers = new String[Engine.ROUND_COUNT];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            evenGameQuestions[i] = generateEvenQuestion();
            evenGameCorrectAnswers[i] = generateEvenCorrectAnswer(evenGameQuestions[i]);
        }
        Engine.runGame(EVEN_RULE, evenGameQuestions, evenGameCorrectAnswers);
    }

    public static String generateEvenQuestion() {
        return String.valueOf(RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER));
    }

    public static String generateEvenCorrectAnswer(String question) {
        int questionToInt = Integer.parseInt(question);
        return isEvenNumber(questionToInt);
    }

    public static String isEvenNumber(int inputNumber) {
        String correctAnswer = "no";

        if (inputNumber % 2 == 0) {
            correctAnswer = "yes";
        }
        return correctAnswer;
    }
}
