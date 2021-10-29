import java.io.IOException;
import java.util.Scanner;

public class Difficulty {

    static String difficultyChoice =  "";

    static void DifficultyMenu() throws IOException, InterruptedException {


        System.out.println("""
                \n****************************************************************
                ****************** Difficulty Selection Menu *******************
                ****************************************************************
                **                                                     Press  **
                ** Easy (5x5 board with 4s to hit the beaver)           -> 1  **
                ** Normal (7x7 board with 3.5s to hit the beaver)       -> 2  **
                ** Hard (10x10 board with 3s to hit the beaver)         -> 3  **
                ** Back to main menu                                          **
                ****************************************************************
                ****************************************************************   
                """);


            Scanner scan = new Scanner(System.in);
            System.out.print("Please enter your choice : ");
            difficultyChoice = scan.nextLine();
            while (!(difficultyChoice.equals("1") || difficultyChoice.equals("2") || difficultyChoice.equals("3") || difficultyChoice.equals("4"))) {
                System.out.print("Invalid choice\nPlease enter your choice : ");
                difficultyChoice = scan.nextLine();
        }

        //difficulty choice changes Board size and timer for each rounds
        switch (difficultyChoice) {

            case "1":
                System.out.println("\nYou choose easy!!!\n");
                System.out.println("Launching game...\n");
                BoardManagement.BoardGeneration("1");
                GameLoop.roundTime=40;
                break;

            case "2":
                System.out.println("You choose normal!!!");
                System.out.println("Launching game...\n");
                BoardManagement.BoardGeneration("2");
                GameLoop.roundTime=35;
                break;

            case "3":
                System.out.println("You choose hard!!!");
                System.out.println("Launching game...\n");
                BoardManagement.BoardGeneration("3");
                GameLoop.roundTime=30;
                break;

            case "4":
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