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
        return RandomUtils.generateRandomNumber() + "";
    }

    public static String generateEvenCorrectAnswer(String question) {
        int questionToInt = Integer.parseInt(question);
        String correctAnswer = "no";

        if (questionToInt % 2 == 0) {
            correctAnswer = "yes";
        }
        return correctAnswer;
    }
}
