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
            Engine.informAboutWrongAnswer(playerAnswer, correctAnswer, playerName);
        }
    }

    static int findGCD(int firstOutputElement, int secondOutputElement) {
        if (secondOutputElement == 0) {
            return firstOutputElement;
        }
        return findGCD(secondOutputElement, firstOutputElement % secondOutputElement);
    }
}
