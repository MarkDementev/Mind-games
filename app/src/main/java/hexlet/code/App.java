package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
        Scanner playerInteractionScanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        String playerInteractionType = playerInteractionScanner.next();
        System.out.println("");
        startSelectedGame(playerInteractionType);
        playerInteractionScanner.close();
    }

    private static void startSelectedGame(String playerInteractionType) {
        switch (playerInteractionType) {
            case "1" -> Cli.meetPlayer();
            case "2" -> Even.playEvenGame();
            case "3" -> Calculator.prepareCalculatorAnswersQuestionsAndStartEngine();
            case "4" -> GCD.makeGCDQuestionsAnswersThenEngine();
            case "5" -> Progression.startProgressionGameThenEngine();
            case "6" -> Prime.startPrimeGame();
            case "0" -> System.out.println("Good bye!");
            default -> System.out.println("Please, input only 1 or 0.");
        }
    }
}
