import java.util.Scanner;

public class DisplayMenu {

        static void displayMenu() {

            System.out.println("\t\t\t\t\t" + "Welcome to hit the beaver!!!!!!\n");
            System.out.println("What do you want to do : \n");
            System.out.println("""
                    1. Play game
                    2. High Scores
                    3. Quit
                    """);
            System.out.println("choice : ");

            /* Recover choice of the player*/

            Scanner scan = new Scanner(System.in);
            int playerChoiceMenu = scan.nextInt();

            /*switch by playerChoiceMenu*/
            switch (playerChoiceMenu) {
                case 1:
                    /* To Function Difficulty choice*/
                    break;
                case 2:
                    /* show high scores table*/
                    break;
                case 3:
                    System.out.println("See you later!!!!");
                    break;
                default:
                    /* if wrong selection of option return to Display Menu*/
                    System.out.println("Please enter 1, 2 or 3");
                    displayMenu();

        }
    }
}
