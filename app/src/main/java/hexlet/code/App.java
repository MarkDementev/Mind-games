package hexlet.code;

//import hexlet.code.games.Calculator;
import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
        Scanner playerInteractionScanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        String playerInteractionType = playerInteractionScanner.next();
        System.out.println("");
        playerCommunicationOrStartGame(playerInteractionType);
        playerInteractionScanner.close();
    }

    private static void playerCommunicationOrStartGame(String playerInteractionType) {
        String[][] questionsAnswersPairs = new String[Engine.ROUND_COUNT][];
        switch (playerInteractionType) {
            case "0" -> System.out.println("Good bye!");
            case "1" -> Cli.meetPlayer();
            case "2","3","4","5","6" -> {
                for (int i = 0; i < Engine.ROUND_COUNT; i++) {
                    questionsAnswersPairs[i] = runGameRound();
                }
                startGame(questionsAnswersPairs);
            }
            default -> System.out.println("Please, input only 1 or 0.");
        }
    }

    private static String[] runGameRound() {
        return Calculator.generateCalculatorQuestionAndAnswerPair();
    }

    private static void startGame(String[][] questionsAnswersPairs) {
        Calculator.startCalculatorGame(questionsAnswersPairs);
    }




    private static void startSelectedGame(String playerInteractionType) {
        switch (playerInteractionType) {
            case "1" -> Cli.meetPlayer();
            case "2" -> Even.playEvenGame();
            case "3" -> Calculator.playCalculatorGame();
            case "4" -> GCD.playGCDGame();
            case "5" -> Progression.playProgressionGame();
            case "6" -> Prime.playPrimeGame();
            case "0" -> System.out.println("Good bye!");
            default -> System.out.println("Please, input only 1 or 0.");
        }
    }
}
