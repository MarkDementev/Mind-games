package hexlet.code;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        setGameOrJustGreet();
    }

    public static void setGameOrJustGreet() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("0 - Exit");
        Scanner playerInteractionScanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        int playerInteractionType = playerInteractionScanner.nextInt();
        System.out.println("");

        if (playerInteractionType == 1) {
            Cli.meetPlayer();
        } else if (playerInteractionType == 2) {
            String playerName = Cli.meetPlayer();
            Even.playEvenGame(playerName);
        } else if (playerInteractionType == 0) {
            System.out.println("Good bye!");
        } else {
            System.out.println("Please, input only 1 or 0.");
            setGameOrJustGreet();
        }
        playerInteractionScanner.close();
    }
}
