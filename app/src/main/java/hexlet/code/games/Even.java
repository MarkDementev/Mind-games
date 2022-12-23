package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Even {
    public static final int EVEN_GAME_SEQUENCE_NUMBER = 2;
    public static final String EVEN_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static void playEvenGame() {
        Engine.playerIntroduction();
        Engine.showGameRule(EVEN_GAME_SEQUENCE_NUMBER);
        Engine.askQuestionsToEnd(EVEN_GAME_SEQUENCE_NUMBER);
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
