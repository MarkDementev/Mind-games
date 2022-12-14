package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Calculator {
    public static final int CALCULATOR_GAME_SEQUENCE_NUMBER = 3;
    public static final String CALCULATOR_RULE = "What is the result of the expression?";
    public static void playCalculatorGame() {
        Engine.playerIntroduction();
        Engine.showGameRule(CALCULATOR_GAME_SEQUENCE_NUMBER);
        Engine.askQuestionsToEnd(CALCULATOR_GAME_SEQUENCE_NUMBER);
    }

    public static String generateCalculatorQuestion() {
        int firstCalculationElement = RandomUtils.generateRandomNumber();
        int secondCalculationElement = RandomUtils.generateRandomNumber();
        int mathOperatorGeneratorElement = RandomUtils.generateRandomNumber();
        String question;

        if (mathOperatorGeneratorElement < 33) {
            question = firstCalculationElement + " + " + secondCalculationElement;
        } else if (mathOperatorGeneratorElement > 33 && mathOperatorGeneratorElement < 67) {
            question = firstCalculationElement + " - " + secondCalculationElement;
        } else {
            question = firstCalculationElement + " * " + secondCalculationElement;
        }
        return question;
    }

    public static String generateCalculatorCorrectAnswer(String question) {
        String arraySeparator;

        if (question.contains("+")) {
            arraySeparator = " \\+ ";
        } else if (question.contains("-")) {
            arraySeparator = " - ";
        } else {
            arraySeparator = " \\* ";
        }
        String[] questionToArr = question.split(arraySeparator);
        int firstAnswerCalculationElement = Integer.parseInt(questionToArr[0]);
        int secondAnswerCalculationElement = Integer.parseInt(questionToArr[1]);

        switch (arraySeparator) {
            case " \\+ ":
                return firstAnswerCalculationElement + secondAnswerCalculationElement + "";
            case " - ":
                return firstAnswerCalculationElement - secondAnswerCalculationElement + "";
            default:
                return firstAnswerCalculationElement * secondAnswerCalculationElement + "";
        }
    }
}
