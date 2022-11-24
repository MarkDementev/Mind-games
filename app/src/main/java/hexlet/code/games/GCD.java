package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GCD {
    public static void gCDNewRound(String playerName) {
        int firstOutputElement = Engine.calcRandomNumber();
        int secondOutputElement = Engine.calcRandomNumber();
        String correctAnswer = "" + findGCD(firstOutputElement, secondOutputElement);

        Scanner gCDScanner = new Scanner(System.in);
        System.out.println("Question: " + firstOutputElement + " " + secondOutputElement);
        System.out.print("Your answer: ");
        String playerAnswer = gCDScanner.next();

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

    static int findGCD(int firstOutputElement, int secondOutputElement) {
        if (secondOutputElement == 0) {
            return firstOutputElement;
        }
        return findGCD(secondOutputElement, firstOutputElement % secondOutputElement);
    }
}
