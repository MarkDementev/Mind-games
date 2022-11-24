package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class Calc {
    public static void calcNewRound(String playerName) {
        int firstCalcElement = Engine.calcRandomNumber();
        int secondCalcElement = Engine.calcRandomNumber();
        double mathOperatorGeneratorElement = Math.random();
        String outputMathExpression;
        String correctAnswer;

        if (mathOperatorGeneratorElement < 0.33) {
            outputMathExpression = firstCalcElement + " + " + secondCalcElement;
            correctAnswer = "" + (firstCalcElement + secondCalcElement);
        } else if (mathOperatorGeneratorElement > 0.33 && mathOperatorGeneratorElement < 0.67) {
            outputMathExpression = firstCalcElement + " - " + secondCalcElement;
            correctAnswer = "" + (firstCalcElement - secondCalcElement);
        } else {
            outputMathExpression = firstCalcElement + " * " + secondCalcElement;
            correctAnswer = "" + (firstCalcElement * secondCalcElement);
        }

        Scanner calcScanner = new Scanner(System.in);
        System.out.println("Question: " + outputMathExpression);
        System.out.print("Your answer: ");
        String playerAnswer = calcScanner.next();

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
