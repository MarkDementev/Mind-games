package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static final String WELCOME_MESSAGE_CLI = "\nWelcome to the Brain Games!";
    public static final String PLAYER_NAME_REQUEST_CLI = "May I have your name? ";

    public static void meetPlayer() {
        System.out.println(WELCOME_MESSAGE_CLI);
        System.out.print(PLAYER_NAME_REQUEST_CLI);
        Scanner playerNameScanner = new Scanner(System.in);
        String playerName = playerNameScanner.next();
        System.out.println("Hello, " + playerName + "!");
    }
}
