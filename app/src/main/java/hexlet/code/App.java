package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String playerName;
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("0 - Exit");
        Scanner playerInteractionScanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        String playerInteractionType = playerInteractionScanner.next();
        System.out.println("");

        switch (playerInteractionType) {
            case "1":
                Cli.meetPlayer();
                break;
            case "2":
                playerName = Cli.meetPlayer();
                Engine.makeStartRoundsFinalize(playerName, 2);
                break;
            case "3":
                playerName = Cli.meetPlayer();
                Engine.makeStartRoundsFinalize(playerName, 3);
                break;
            case "4":
                playerName = Cli.meetPlayer();
                Engine.makeStartRoundsFinalize(playerName, 4);
                break;
            case "0":
                System.out.println("Good bye!");
                break;
            default:
                System.out.println("Please, input only 1 or 0.");
        }
        playerInteractionScanner.close();
    }
}
