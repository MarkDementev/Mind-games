package hexlet.code.helperClasses;

import hexlet.code.Engine;
import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;

public class GameDataToEnginePreparer {
    public static String[] gameQuestions = new String[Engine.ROUND_COUNT];
    public static String[] gameAnswers = new String[Engine.ROUND_COUNT];
    public static void formQuestionsAnswersThenRunEngine(String gameType, String gameRule) {
        for (int i = 0; i < Engine.ROUND_COUNT; i++) {
            switch (gameType) {
                case "Even":
                    gameQuestions[i] = Even.generateEvenQuestion();
                    gameAnswers[i] = Even.generateEvenCorrectAnswer(gameQuestions[i]);
                    break;
                case "Calculator":
                    gameQuestions[i] = Calculator.generateCalculatorQuestion();
                    gameAnswers[i] = Calculator.generateCalculatorCorrectAnswer(gameQuestions[i]);
                    break;
                case "GCD":
                    gameQuestions[i] = GCD.generateGCDQuestion();
                    gameAnswers[i] = GCD.generateGCDCorrectAnswer(gameQuestions[i]);
                    break;
                case "Progression":
                    gameQuestions[i] = Progression.generateProgressionQuestion();
                    gameAnswers[i] = Progression.generateProgressionCorrectAnswer(gameQuestions[i]);
                    break;
                default:
                    gameQuestions[i] = Prime.generatePrimeQuestion();
                    gameAnswers[i] = Prime.generatePrimeCorrectAnswer(gameQuestions[i]);
            }
        }
        Engine.runGame(gameRule, gameQuestions, gameAnswers);
    }
}
