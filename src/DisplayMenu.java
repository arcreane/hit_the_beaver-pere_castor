import java.util.Scanner;

public class DisplayMenu {

        static void displayMenu() {
            Scanner scan = new Scanner(System.in);

            HighScore scoreManager = new HighScore(scan);
            scoreManager.importSavedScores();

            String playerChoiceMenu;

            System.out.println("\t\t\t\t\t" + "Welcome to hit the beaver!!!!!!\n");

            while (true) {
                System.out.println("What do you want to do : \n");
                System.out.println("""
                        1. Play game
                        2. High Scores
                        3. Quit
                        """);
                System.out.println("choice : ");
                playerChoiceMenu = scan.nextLine();

                /*Condition to avoid string answer*/

                if (playerChoiceMenu.equals("1") || playerChoiceMenu.equals("2") || playerChoiceMenu.equals("3")) {
                    break;
                } else
                    System.out.println("Please enter a valid choice");

            }


            /*switch by playerChoiceMenu*/
            //playerChoice = Integer.valueOf(playerChoiceMenu);



            switch (playerChoiceMenu) {
                case "1" :
                    /* To Function Difficulty choice*/
                    System.out.println("You choose to play");
                    Difficulty.DifficultyMenu();
                    break;

                case "2" :
                    /* show high scores table*/
                    System.out.println("You choose to watch High scores");
                    scoreManager.sort();
                    scoreManager.getScores();
                    break;

                default:
                    /* Quit the menu*/
                    System.out.println("See you later!!!!");
                    break;

        }
    }
}
