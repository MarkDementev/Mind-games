package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Calculator {
    public static final String CALCULATOR_RULE = "What is the result of the expression?";
    private static final int EXPRESSION_ELEMENT_LOWER_BORDER = 2;
    private static final int EXPRESSION_ELEMENT_UPPER_BORDER = 50;
    private static final int MATH_OPERATOR_ELECTOR_LOWER_BORDER = 0;
    private static final int MATH_OPERATOR_ELECTOR_UPPER_BORDER = 2;
    private static final String[] CALCULATOR_OPERATORS = {" + ", " - ", " * "};
    //прописываю диапазон генерации элементов [2;50], чтобы упростить пользователю счёт "в уме"
    //но начал его с 2, чтобы не пришлось без интереса пользователю умножать на 0 или 1

    public static void startCalculatorGame() {
        String[][] calculatorQuestionsAnswers = new String[Engine.ROUND_COUNT][];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            calculatorQuestionsAnswers[i] = generateCalculatorQuestionAndAnswerPair();
        }
        Engine.runGame(CALCULATOR_RULE, calculatorQuestionsAnswers);
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

        if (chosenMathOperator.equals(CALCULATOR_OPERATORS[0])) {
            questionAnswerPair[1] = String.valueOf(firstCalculationElement + secondCalculationElement);
        } else if (chosenMathOperator.equals(CALCULATOR_OPERATORS[1])) {
            questionAnswerPair[1] = String.valueOf(firstCalculationElement - secondCalculationElement);
        } else {
            questionAnswerPair[1] = String.valueOf(firstCalculationElement * secondCalculationElement);
        }
        questionAnswerPair[0] = firstCalculationElement + chosenMathOperator + secondCalculationElement;
        return questionAnswerPair;
    }
}
