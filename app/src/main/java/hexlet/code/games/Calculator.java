package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.utils.RandomUtils;

public class Calculator {
    public static final String CALCULATOR_RULE = "What is the result of the expression?";
    public static final int FIRST_PERCENT_BORDER = 33;
    public static final int SECOND_PERCENT_BORDER = 67;
    private static final int CALCULATOR_LOWER_BORDER = 2;
    private static final int CALCULATOR_UPPER_BORDER = 50;
    private static final String[] CALCULATOR_OPERATORS = {" + ", " - ", " * "};
    //прописываю диапазон генерации элементов [2;50], чтобы упростить пользователю счёт "в уме"
    //но начал его с 2, чтобы не пришлось без интереса пользователю умножать на 0 или 1

    public static void prepareCalculatorAnswersQuestionsAndStartEngine() {
        String[][] calculatorQuestionsAnswers = new String[Engine.ROUND_COUNT][];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            calculatorQuestionsAnswers[i] = generateCalculatorQuestionAndAnswerPair();
        }
        Engine.runGame(CALCULATOR_RULE, calculatorQuestionsAnswers);
    }

    public static String[] generateCalculatorQuestionAndAnswerPair() {
        int firstCalculationElement = RandomUtils.generateRandomNumber(CALCULATOR_LOWER_BORDER,
                CALCULATOR_UPPER_BORDER);
        int secondCalculationElement = RandomUtils.generateRandomNumber(CALCULATOR_LOWER_BORDER,
                CALCULATOR_UPPER_BORDER);
        int mathOperatorGeneratorElement = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER);
        String[] questionAnswerPair = new String[2];

        if (mathOperatorGeneratorElement < FIRST_PERCENT_BORDER) {
            questionAnswerPair[0] = firstCalculationElement + CALCULATOR_OPERATORS[0] + secondCalculationElement;
            questionAnswerPair[1] = String.valueOf(firstCalculationElement + secondCalculationElement);
        } else if (mathOperatorGeneratorElement > FIRST_PERCENT_BORDER
                && mathOperatorGeneratorElement < SECOND_PERCENT_BORDER) {
            questionAnswerPair[0] = firstCalculationElement + CALCULATOR_OPERATORS[1] + secondCalculationElement;
            questionAnswerPair[1] = String.valueOf(firstCalculationElement - secondCalculationElement);
        } else {
            questionAnswerPair[0] = firstCalculationElement + CALCULATOR_OPERATORS[2] + secondCalculationElement;
            questionAnswerPair[1] = String.valueOf(firstCalculationElement * secondCalculationElement);
        }
        return questionAnswerPair;
    }
}
