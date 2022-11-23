package hexlet.code;

import hexlet.code.games.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        setGameOrJustGreet();
    }

    public static void setGameOrJustGreet() {
        String playerName;
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("0 - Exit");
        Scanner playerInteractionScanner = new Scanner(System.in);
        System.out.print("Your choice: ");
        int playerInteractionType = playerInteractionScanner.nextInt();
        System.out.println("");

        switch (playerInteractionType) {
            case 1:
                Cli.meetPlayer();
                break;
            case 2:
                playerName = Cli.meetPlayer();
                Even.playEvenGame(playerName);
                break;
            case 3:
                playerName = Cli.meetPlayer();
                Calc.playCalcGame(playerName);
                break;
            case 0:
                System.out.println("Good bye!");
                break;
            default:
                System.out.println("Please, input only 1 or 0.");
                setGameOrJustGreet();
        }
        playerInteractionScanner.close();
    }
}
