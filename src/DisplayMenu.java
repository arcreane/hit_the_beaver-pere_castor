import java.util.Scanner;

public class DisplayMenu {

        static void displayMenu() {

            System.out.println("Welcome to hit the beaver!!!!!!");
            System.out.println("What do you want to do : ");
            System.out.println("""
                    1. Play game
                    2. High Scores
                    3. Quit
                    """);
            System.out.println("choice : ");
            Scanner scan = new Scanner(System.in);
            int playerChoiceMenu = scan.nextInt();

            switch (playerChoiceMenu) {
                case 1:
                    /* To Fonction Difficulty choice*/
                    break;
                case 2:
                    /* show high scores table*/
                    break;
                case 3:
                    System.out.println("See you later!!!!");
                    break;
                default:
                    System.out.println("Please enter 1, 2 or 3");
                    displayMenu();

        }
    }
}
