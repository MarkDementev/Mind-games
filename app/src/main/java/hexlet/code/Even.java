package hexlet.code;

import  java.util.Scanner;

public class Even {
    public static void playEvenGame(String playerName) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int correctAnswersCount = 0; correctAnswersCount < 3; correctAnswersCount++) {
            askNewQuestion(playerName);
        }
        System.out.println("Congratulations, " + playerName + "!");
    }

    static void askNewQuestion(String playerName) {
        int upperRandomBorder = 101;
        int outputNumber = (int) (Math.random() * upperRandomBorder);
        boolean isEvenOutputNumber = false;
        String correctAnswer = "no";

        if (outputNumber % 2 == 0) {
            isEvenOutputNumber = true;
            correctAnswer = "yes";
        }

        Scanner isEvenScanner = new Scanner(System.in);
        System.out.println("Question: " + outputNumber);
        System.out.print("Your answer: ");
        String playerAnswer = isEvenScanner.next();

        if ((isEvenOutputNumber && playerAnswer.equals("yes"))
                || (!isEvenOutputNumber && playerAnswer.equals("no"))) {
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
