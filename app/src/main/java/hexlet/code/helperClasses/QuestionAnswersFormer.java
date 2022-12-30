package hexlet.code.helperClasses;

import hexlet.code.Engine;
import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class QuestionAnswersFormer {
    public static String[] formQuestionsArr(String gameType) {
        String[] gameQuestions = new String[Engine.ROUND_COUNT];
        switch (gameType) {
            case "Even":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = Even.generateEvenQuestion();
                }
                break;
            case "Calculator":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = Calculator.generateCalculatorQuestion();
                }
                break;
            case "GCD":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = GCD.generateGCDQuestion();
                }
                break;
            case "Progression":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = Progression.generateProgressionQuestion();
                }
                break;
            default:
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = Prime.generatePrimeQuestion();
                }
        }
        return gameQuestions;
    }
    public static String[] formAnswersArr(String gameType, String[] questions) {
        String[] gameAnswers = new String[Engine.ROUND_COUNT];
        switch (gameType) {
            case "Even":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameAnswers[i] = Even.generateEvenCorrectAnswer(questions[i]);
                }
                break;
            case "Calculator":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameAnswers[i] = Calculator.generateCalculatorCorrectAnswer(questions[i]);
                }
                break;
            case "GCD":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameAnswers[i] = GCD.generateGCDCorrectAnswer(questions[i]);
                }
                break;
            case "Progression":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameAnswers[i] = Progression.generateProgressionCorrectAnswer(questions[i]);
                }
                break;
            default:
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameAnswers[i] = Prime.generatePrimeCorrectAnswer(questions[i]);
                }
        }
        return gameAnswers;
    }
}
