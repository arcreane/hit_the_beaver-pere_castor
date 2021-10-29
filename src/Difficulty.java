import java.io.IOException;
import java.util.Scanner;

public class Difficulty {

    static String playerChoiceDifficulty =  "";


    static void DifficultyMenu() throws IOException, InterruptedException {

        while (true) {
            System.out.println("Hit the beaver !!!!!");
            System.out.println("Choose your difficulty : ");
            System.out.println("""
                    1. Easy (table 5x5 with 4s to hit)
                    2. Normal (table 7x7 with 3.5s to hit)
                    3. Hard (table 10x10 with 3s to hit)
                    4. Arcade
                    5. Back to main menu
                             
                       """);

            System.out.println("Choice : ");
            Scanner scan = new Scanner(System.in);
            playerChoiceDifficulty = scan.nextLine();
            if (playerChoiceDifficulty.equals("1") || playerChoiceDifficulty.equals("2") || playerChoiceDifficulty.equals("3") || playerChoiceDifficulty.equals("4") || playerChoiceDifficulty.equals("5")) {
                break;
            } else
                System.out.println("Please enter a valid choice");

        }

        //difficulty choice changes Board size and timer for each rounds
        switch (playerChoiceDifficulty) {

            case "1":
                System.out.println("You choose easy!!!");
                BoardManagement.BoardGeneration("1");
                GameLoop.roundTime=40;
                break;

            case "2":
                System.out.println("You choose normal!!!");
                BoardManagement.BoardGeneration("2");
                GameLoop.roundTime=35;
                break;

            case "3":
                System.out.println("You choose hard!!!");
                BoardManagement.BoardGeneration("3");
                GameLoop.roundTime=30;
                break;

            case "4":
                System.out.println("You choose Arcade mode");
                BoardManagement.BoardGeneration("1");
                GameLoop.roundTime=50-GameLoop.roundNumber;
                GameLoop.arcade=Boolean.TRUE;

                break;

            case "5":
                System.out.println("You choose to go back to main menu");
                DisplayMenu.displayMenu();
                break;

            default:
                /* if wrong selection of option return to Display Menu*/
                DifficultyMenu();


        }
        GameLoop.GameCount();
        GameLoop.GameRound();
    }

}