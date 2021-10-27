import java.util.Scanner;

public class Difficulty {

    static String[][] DifficultyMenu() {

        String [][] gameBoard = new String [0][0];

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
        int playerChoiceDifficulty = scan.nextInt();

        switch (playerChoiceDifficulty) {

            case 1:
                System.out.println("You choose easy!!!");
                gameBoard = BoardManagement.BoardGeneration(5, 5);

            case 2:
                System.out.println("You choose normal!!!");
                gameBoard = BoardManagement.BoardGeneration(7, 7);

            case 3:
                System.out.println("You choose hard!!!");
                gameBoard = BoardManagement.BoardGeneration(10, 10);

            case 4:
                System.out.println("You choose to go back to main menu");
                DisplayMenu.displayMenu();

            default:
                /* if wrong selection of option return to Display Menu*/
                System.out.println("Please enter 1, 2 or 3");
                DifficultyMenu();

                return gameBoard;
        }
    }
}