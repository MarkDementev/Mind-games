package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String meetPlayer() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner playerNameScanner = new Scanner(System.in);
        String playerName = playerNameScanner.next();
        System.out.println("Hello, " + playerName + "!");
        return playerName;
    }
}
