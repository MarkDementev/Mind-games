package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class CalculatorGame {
    public static final String CALCULATOR_RULE = "What is the result of the expression?";
    public static final String MATH_OPERATOR_NOT_CHOSEN_ERROR_TEXT =
            "Математическая операция почему-то не определилась к этому моменту."
                    + " А должна была определиться случайным образом без участия игрока..."
                    + " Проблема в коде программы, требует исправления!!!";
    private static final int EXPRESSION_ELEMENT_LOWER_BORDER = 2;
    private static final int EXPRESSION_ELEMENT_UPPER_BORDER = 50;
    private static final int MATH_OPERATOR_ELECTOR_LOWER_BORDER = 0;
    private static final int MATH_OPERATOR_ELECTOR_UPPER_BORDER = 2;
    private static final String[] CALCULATOR_OPERATORS = {" + ", " - ", " * "};

    public static void startCalculatorGame() {
        String[][] questionAnswerPairs = new String[Engine.ROUND_COUNT][];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            questionAnswerPairs[i] = generateCalculatorQuestionAndAnswerPair();
        }
        Engine.runGame(CALCULATOR_RULE, questionAnswerPairs);
    }

    public static String[] generateCalculatorQuestionAndAnswerPair() {
        String[] questionAnswerPair = new String[2];

        int firstCalculationElement = RandomUtils.generateRandomNumber(EXPRESSION_ELEMENT_LOWER_BORDER,
                EXPRESSION_ELEMENT_UPPER_BORDER);
        int secondCalculationElement = RandomUtils.generateRandomNumber(EXPRESSION_ELEMENT_LOWER_BORDER,
                EXPRESSION_ELEMENT_UPPER_BORDER);
        int mathOperatorGeneratorElement = RandomUtils.generateRandomNumber(MATH_OPERATOR_ELECTOR_LOWER_BORDER,
                MATH_OPERATOR_ELECTOR_UPPER_BORDER);
        String chosenMathOperator = CALCULATOR_OPERATORS[mathOperatorGeneratorElement];

        switch (chosenMathOperator) {
            case " + ":
                questionAnswerPair[1] = String.valueOf(firstCalculationElement + secondCalculationElement);
                break;
            case " - ":
                questionAnswerPair[1] = String.valueOf(firstCalculationElement - secondCalculationElement);
                break;
            case " * ":
                questionAnswerPair[1] = String.valueOf(firstCalculationElement * secondCalculationElement);
                break;
            default:
                throw new NullPointerException(MATH_OPERATOR_NOT_CHOSEN_ERROR_TEXT);
        }
        questionAnswerPair[0] = firstCalculationElement + chosenMathOperator + secondCalculationElement;
        return questionAnswerPair;
    }
}
