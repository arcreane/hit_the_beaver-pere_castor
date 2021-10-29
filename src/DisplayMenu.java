import java.io.IOException;
import java.util.Scanner;

public class DisplayMenu {

    static Scanner scan = new Scanner(System.in);
    static HighScore scoreManager = new HighScore(scan);

    static void displayMenu() throws IOException, InterruptedException {

        scoreManager.importSavedScores();

        String playerChoiceMenu;

        System.out.println("\t\t\t\t\t" + """
               
                **************************************************************************************************
                *********************************************  WELCOME TO  ***************************************
                **************************************************************************************************
                ██╗  ██╗██╗████████╗  ████████╗██╗  ██╗███████╗  ██████╗ ███████╗ █████╗ ██╗   ██╗███████╗██████╗ 
                ██║  ██║██║╚══██╔══╝  ╚══██╔══╝██║  ██║██╔════╝  ██╔══██╗██╔════╝██╔══██╗██║   ██║██╔════╝██╔══██╗
                ███████║██║   ██║        ██║   ███████║█████╗    ██████╦╝█████╗  ███████║╚██╗ ██╔╝█████╗  ██████╔╝
                ██╔══██║██║   ██║        ██║   ██╔══██║██╔══╝    ██╔══██╗██╔══╝  ██╔══██║ ╚████╔╝ ██╔══╝  ██╔══██╗
                ██║  ██║██║   ██║        ██║   ██║  ██║███████╗  ██████╦╝███████╗██║  ██║  ╚██╔╝  ███████╗██║  ██║
                ╚═╝  ╚═╝╚═╝   ╚═╝        ╚═╝   ╚═╝  ╚═╝╚══════╝  ╚═════╝ ╚══════╝╚═╝  ╚═╝   ╚═╝   ╚══════╝╚═╝  ╚═╝
                                                              n__n_
                                                             /  = =//
                                                            /   ._Y_)
                                                ___________/      "//___________________
                                                          (_/  (_,  //                        
                                                           / /      ( //_,--""/""--.
                                                      __..-,-`.___,-` )-.______.'/s
                                                    <'     `-,'   `-, )-'    >
                                                     `----._/      ( /"`>.--"
                                                            "--..___,--"
                \n""");

        while (true) {
            System.out.println("""
                        *******************************
                        ********** Main Menu **********
                        *******************************
                        **                    Press  **
                        ** Play game           -> 1  **
                        ** High Scores         -> 2  **
                        ** Quit                -> 3  **
                        *******************************
                        *******************************
                        """);
            System.out.println("Please enter your choice : ");
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
                Difficulty.DifficultyMenu();
                break;

            case "2" :
                /* show high scores table*/
                System.out.println("Loading high scores...\n");
                scoreManager.sort();
                scoreManager.getScores();
                System.out.println("Press Enter to access the main menu\n");
                scan.nextLine();
                displayMenu();
                break;

            default:
                /* Quit the menu*/
                System.out.println("\nSee you later!!!! =^.^=");
                scoreManager.save();
                System.exit(0);

        }
    }
}