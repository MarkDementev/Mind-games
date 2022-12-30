package hexlet.code.helperClasses;

import hexlet.code.Engine;
import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class GameDataToEnginePreparer {
    public static void formQuestionsAnswersThenRunEngine(String gameType, String gameRule) {
        String[] gameQuestions = new String[Engine.ROUND_COUNT];
        String[] gameAnswers = new String[Engine.ROUND_COUNT];
        switch (gameType) {
            case "Even":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = Even.generateEvenQuestion();
                    gameAnswers[i] = Even.generateEvenCorrectAnswer(gameQuestions[i]);
                }
                break;
            case "Calculator":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = Calculator.generateCalculatorQuestion();
                    gameAnswers[i] = Calculator.generateCalculatorCorrectAnswer(gameQuestions[i]);
                }
                break;
            case "GCD":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = GCD.generateGCDQuestion();
                    gameAnswers[i] = GCD.generateGCDCorrectAnswer(gameQuestions[i]);
                }
                break;
            case "Progression":
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = Progression.generateProgressionQuestion();
                    gameAnswers[i] = Progression.generateProgressionCorrectAnswer(gameQuestions[i]);
                }
                break;
            default:
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    gameQuestions[i] = Prime.generatePrimeQuestion();
                    gameAnswers[i] = Prime.generatePrimeCorrectAnswer(gameQuestions[i]);
                }
        }
        Engine.runGame(gameRule, gameQuestions, gameAnswers);
    }
}
