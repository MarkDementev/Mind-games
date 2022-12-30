package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

public class Calculator {
    public static final String CALCULATOR_RULE = "What is the result of the expression?";
    public static final int FIRST_PERCENT_BORDER = 33;
    public static final int SECOND_PERCENT_BORDER = 67;
    private static final int CALCULATOR_LOWER_BORDER = 2;
    private static final int CALCULATOR_UPPER_BORDER = 50;
    //прописываю диапазон генерации элементов [2;50], чтобы упростить пользователю счёт "в уме"
    //но начал его с 2, чтобы не пришлось без интереса пользователю умножать на 0 или 1
    public static void playCalculatorGame() {
        String[] calculatorGameQuestions = new String[Engine.ROUND_COUNT];
        String[] calculatorGameCorrectAnswers = new String[Engine.ROUND_COUNT];

        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            calculatorGameQuestions[i] = generateCalculatorQuestion();
            calculatorGameCorrectAnswers[i] = generateCalculatorCorrectAnswer(calculatorGameQuestions[i]);
        }
        Engine.runGame(CALCULATOR_RULE, calculatorGameQuestions, calculatorGameCorrectAnswers);
    }

    public static String generateCalculatorQuestion() {
        int firstCalculationElement = RandomUtils.generateRandomNumber(CALCULATOR_LOWER_BORDER,
                CALCULATOR_UPPER_BORDER);
        int secondCalculationElement = RandomUtils.generateRandomNumber(CALCULATOR_LOWER_BORDER,
                CALCULATOR_UPPER_BORDER);
        int mathOperatorGeneratorElement = RandomUtils.generateRandomNumber(RandomUtils.DEFAULT_LOWER_BORDER,
                RandomUtils.DEFAULT_UPPER_BORDER);
        String question;

        if (mathOperatorGeneratorElement < FIRST_PERCENT_BORDER) {
            question = firstCalculationElement + " + " + secondCalculationElement;
        } else if (mathOperatorGeneratorElement > FIRST_PERCENT_BORDER
                && mathOperatorGeneratorElement < SECOND_PERCENT_BORDER) {
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
                return String.valueOf(firstAnswerCalculationElement + secondAnswerCalculationElement);
            case " - ":
                return String.valueOf(firstAnswerCalculationElement - secondAnswerCalculationElement);
            default:
                return String.valueOf(firstAnswerCalculationElement * secondAnswerCalculationElement);
        }
    }
}
