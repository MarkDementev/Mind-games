package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUND_COUNT = 3;

    public static void runGame(String gameRule, String[][] questionsAnswersPairs) {
        String playerName;
        String playerAnswer;
        Scanner nameAndAnswerScanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!\nMay I have your name? ");
        playerName = nameAndAnswerScanner.next();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameRule);
        for (int i = 0; i < ROUND_COUNT; i++) {
            System.out.println("Question: " + questionsAnswersPairs[i][0]);
            System.out.print("Your answer: ");
            playerAnswer = nameAndAnswerScanner.next();
            if (playerAnswer.equals(questionsAnswersPairs[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + playerAnswer + "'"
                        + " is wrong answer ;(. Correct answer was"
                        + " '" + questionsAnswersPairs[i][1] + "'.");
                System.out.println("Let's try again, " + playerName + "!");
                System.exit(0);
            }
        }
        System.out.println("Congratulations, " + playerName + "!");
    }
}

