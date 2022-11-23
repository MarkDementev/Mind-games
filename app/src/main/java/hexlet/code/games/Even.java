package hexlet.code.games;

import java.util.Scanner;

public class Even {
    public static void evenNewRound(String playerName) {
        final int RANDOM_NUMBER_UPPER_BORDER = 101;
        int outputNumber = (int) (Math.random() * RANDOM_NUMBER_UPPER_BORDER);
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
