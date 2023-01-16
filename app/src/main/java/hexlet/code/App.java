package hexlet.code;

import hexlet.code.games.Calculator;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    static final String INTRODUCTION_MESSAGE = "Please enter the game number and press Enter.";
    static final String GAMES_ENUMERATION =
            "1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit";
    static final String OFFER_MAKE_CHOICE = "Your choice: ";
    static final String CHOSEN_NO_GAMES_TEXT = "Good bye!";
    static final String WRONG_INPUT_ERROR = "Please, input only 1 or 0.";
    public static void main(String[] args) {
        System.out.println(INTRODUCTION_MESSAGE);
        System.out.println(GAMES_ENUMERATION);
        Scanner playerInteractionScanner = new Scanner(System.in);
        System.out.print(OFFER_MAKE_CHOICE);
        String playerInteractionType = playerInteractionScanner.next();
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
            case "0" -> System.out.println(CHOSEN_NO_GAMES_TEXT);
            default -> System.out.println(WRONG_INPUT_ERROR);
        }
    }
}
