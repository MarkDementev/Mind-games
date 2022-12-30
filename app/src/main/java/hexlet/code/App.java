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

    static void startSelectedGame(String playerInteractionType) {
        String[] questions = new String[Engine.ROUND_COUNT];
        String[] correctAnswers = new String[Engine.ROUND_COUNT];

        switch (playerInteractionType) {
            case "1":
                Cli.meetPlayer();
                break;
            case "2":
                Even.playEvenGame(questions, correctAnswers);
                break;
            case "3":
                Calculator.playCalculatorGame(questions, correctAnswers);
                break;
            case "4":
                GCD.playGCDGame(questions, correctAnswers);
                break;
            case "5":
                Progression.playProgressionGame(questions, correctAnswers);
                break;
            case "6":
                Prime.playPrimeGame(questions, correctAnswers);
                break;
            case "0":
                System.out.println("Good bye!");
                break;
            default:
                System.out.println("Please, input only 1 or 0.");
        }
    }
}
