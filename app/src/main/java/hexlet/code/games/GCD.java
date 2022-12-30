package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class GCD {
    public static final String GCD_RULE = "Find the greatest common divisor of given numbers.";
    private static final int GCD_LOWER_BORDER = 1;
    //добавил значение мин. границы, чтобы пользователю выпадали ненулевые значения
    public static void playGCDGame() {
        String[] gCDGameQuestions = new String[Engine.ROUND_COUNT];
        String[] gCDGameCorrectAnswers = new String[Engine.ROUND_COUNT];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            gCDGameQuestions[i] = generateGCDQuestion();
            gCDGameCorrectAnswers[i] = generateGCDCorrectAnswer(gCDGameQuestions[i]);
        }
        Engine.runGame(GCD_RULE, gCDGameQuestions, gCDGameCorrectAnswers);
    }

    public static String generateGCDQuestion() {
        int firstOutputElement = RandomUtils.generateRandomNumber(GCD_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER);
        int secondOutputElement = RandomUtils.generateRandomNumber(GCD_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER);
        return firstOutputElement + " " + secondOutputElement;
    }

    public static String generateGCDCorrectAnswer(String question) {
        String[] gCDArr = question.split(" ");
        return String.valueOf(findGCD(Integer.parseInt(gCDArr[0]), Integer.parseInt(gCDArr[1])));
    }

    static int findGCD(int firstOutputElement, int secondOutputElement) {
        if (secondOutputElement == 0) {
            return firstOutputElement;
        }
        return findGCD(secondOutputElement, firstOutputElement % secondOutputElement);
    }
}
