package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class Engine {
    private static final int ROUND_COUNT = 3;
    private static String playerName;

    public static void playerIntroduction() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner playerNameScanner = new Scanner(System.in);
        playerName = playerNameScanner.next();
        System.out.println("Hello, " + playerName + "!");
    }

    public static void showGameRule(int gameType) {
        switch (gameType) {
            case Even.EVEN_GAME_SEQUENCE_NUMBER:
                System.out.println(Even.EVEN_RULE);
                break;
            case Calculator.CALCULATOR_GAME_SEQUENCE_NUMBER:
                System.out.println(Calculator.CALCULATOR_RULE);
                break;
            case GCD.GCD_GAME_SEQUENCE_NUMBER:
                System.out.println(GCD.GCD_RULE);
                break;
            case Progression.PROGRESSION_GAME_SEQUENCE_NUMBER:
                System.out.println(Progression.PROGRESSION_RULE);
                break;
            default:
                System.out.println(Prime.PRIME_RULE);
        }
    }

    public static void askQuestionsToEnd(int gameType) {
        String question;
        String correctAnswer;
        String playerAnswer;
        for (int correctAnswersCount = 0; correctAnswersCount < ROUND_COUNT; correctAnswersCount++) {
            switch (gameType) {
                case Even.EVEN_GAME_SEQUENCE_NUMBER:
                    question = Even.generateEvenQuestion();
                    correctAnswer = Even.generateEvenCorrectAnswer(question);
                    break;
                case Calculator.CALCULATOR_GAME_SEQUENCE_NUMBER:
                    question = Calculator.generateCalculatorQuestion();
                    correctAnswer = Calculator.generateCalculatorCorrectAnswer(question);
                    break;
                case GCD.GCD_GAME_SEQUENCE_NUMBER:
                    question = GCD.generateGCDQuestion();
                    correctAnswer = GCD.generateGCDCorrectAnswer(question);
                    break;
                case Progression.PROGRESSION_GAME_SEQUENCE_NUMBER:
                    question = Progression.generateProgressionQuestion();
                    correctAnswer = Progression.generateProgressionCorrectAnswer(question);
                    break;
                default:
                    question = Prime.generatePrimeQuestion();
                    correctAnswer = Prime.generatePrimeCorrectAnswer(question);
            }
            playerAnswer = Engine.inputPlayerAnswer(question);
            isCorrectAnswer(playerAnswer, correctAnswer);
        }
        System.out.println("Congratulations, " + playerName + "!");
    }

    static String inputPlayerAnswer(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Question: " + question);
        System.out.print("Your answer: ");
        return scanner.next();
    }

    static void isCorrectAnswer(String playerAnswer, String correctAnswer) {
        if (playerAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + playerAnswer + "'"
                    + " is wrong answer ;(. Correct answer was"
                    + " '" + correctAnswer + "'.");
            System.out.println("Let's try again, " + playerName + "!");
            System.exit(0);
        }
    }
}
