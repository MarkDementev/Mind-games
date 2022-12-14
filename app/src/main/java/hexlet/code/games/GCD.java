package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class GCD {
    public static final String GCD_RULE = "Find the greatest common divisor of given numbers.";

    public static void playGCDGame() {
        Engine.playerIntroduction();
        Engine.showGameRule(4);
        Engine.askQuestions(4);
    }

    public static String generateGCDQuestion() {
        int firstOutputElement = RandomUtils.generateRandomNumber();
        int secondOutputElement = RandomUtils.generateRandomNumber();
        return firstOutputElement + " " + secondOutputElement;
    }

    static int findGCD(int firstOutputElement, int secondOutputElement) {
        if (secondOutputElement == 0) {
            return firstOutputElement;
        }
        return findGCD(secondOutputElement, firstOutputElement % secondOutputElement);
    }

    public static String generateGCDCorrectAnswer(String question) {
        String[] gCDArr = question.split(" ");
        return "" + findGCD(Integer.parseInt(gCDArr[0]), Integer.parseInt(gCDArr[1]));
    }
}
