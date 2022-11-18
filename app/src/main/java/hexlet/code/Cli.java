package hexlet.code;

import java.util.Scanner;

public class Cli {
    static void playersGreeting() {
        System.out.print("May I have your name? ");
        Scanner playerNameScanner = new Scanner(System.in);
        String playerName = playerNameScanner.next();
        System.out.println("Hello, " + playerName + "!");
        playerNameScanner.close();
    }
}
