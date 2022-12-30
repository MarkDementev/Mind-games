package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUND_COUNT = 3;

    public static void runGame(String gameRule, String[] questions, String[] correctAnswers) {
        String playerName;
        String playerAnswer;
        Scanner playerNameScanner = new Scanner(System.in);
        Scanner playerAnswerScanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!\nMay I have your name? ");
        playerName = playerNameScanner.next();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameRule);
        for (int i = 0; i < ROUND_COUNT; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            playerAnswer = playerAnswerScanner.next();
            if (playerAnswer.equals(correctAnswers[i])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + playerAnswer + "'"
                        + " is wrong answer ;(. Correct answer was"
                        + " '" + correctAnswers[i] + "'.");
                System.out.println("Let's try again, " + playerName + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}
