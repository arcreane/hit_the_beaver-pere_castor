import java.util.Scanner;

public class Difficulty {

    static void DifficultyMenu() {

        String playerChoiceDifficulty;


        while (true) {
            System.out.println("Hit the beaver !!!!!");
            System.out.println("Choose your difficulty : ");
            System.out.println("""
                    1. Easy (table 5x5 with 4s to hit)
                    2. Normal (table 7x7 with 3.5s to hit)
                    3. Hard (table 10x10 with 3s to hit)
                    4. Back to main menu
                             
                       """);

            System.out.println("Choice : ");
            Scanner scan = new Scanner(System.in);
            playerChoiceDifficulty = scan.nextLine();
            if (playerChoiceDifficulty.equals("1") || playerChoiceDifficulty.equals("2") || playerChoiceDifficulty.equals("3") || playerChoiceDifficulty.equals("4")) {
                break;
            } else
                System.out.println("Please enter a valid choice");

        }

        switch (playerChoiceDifficulty) {

            case "1":
                System.out.println("You choose easy!!!");
                BoardManagement.BoardGeneration("easy");
                break;

            case "2":
                System.out.println("You choose normal!!!");
                BoardManagement.BoardGeneration("normal");
                break;

            case "3":
                System.out.println("You choose hard!!!");
                BoardManagement.BoardGeneration("hard");
                break;

            case "4":
                System.out.println("You choose to go back to main menu");
                DisplayMenu.displayMenu();
                break;

            default:
                /* if wrong selection of option return to Display Menu*/
                DifficultyMenu();


        }
        GameLoop.GamePlay();
    }



}