package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomUtils;

public class Even {
    public static final String EVEN_RULE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static void playEvenGame() {
        String[][] evenQuestionsAnswers = new String[Engine.ROUND_COUNT][];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            evenQuestionsAnswers[i] = makeEvenQuestionAndAnswerPair();
        }
        Engine.runGame(EVEN_RULE, evenQuestionsAnswers);
    }

    public static String[] makeEvenQuestionAndAnswerPair() {
        String[] questionAnswerPair = new String[2];
        questionAnswerPair[0] = String.valueOf(RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER));
        questionAnswerPair[1] = isEvenNumber(Integer.parseInt(questionAnswerPair[0]));
        return questionAnswerPair;
    }

    public static String isEvenNumber(int inputNumber) {
        String correctAnswer = "no";

        if (inputNumber % 2 == 0) {
            correctAnswer = "yes";
        }
        return correctAnswer;
    }
}
