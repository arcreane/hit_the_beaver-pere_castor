import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameLoop {
    static String x_coordinate;
    static String y_coordinate;
    static int roundNumber;
    static int roundTime = 4;
    static String hitFeedback = " ";

    public GameLoop() {
    }

    static void GameCount() throws IOException, InterruptedException {

        roundNumber=0;
        DisplayMenu.scoreManager.reset();

        //3 sec timer before game start
        System.out.println("""
                █▀▀ █▀▀ ▀█▀   █▀█ █▀▀ ▄▀█ █▀▄ █▄█ █
                █▄█ ██▄  █    █▀▄ ██▄ █▀█ █▄▀  █  ▄
                """);

        int i;
        for (i = 0; i < 3; ++i) {
            System.out.println(3 - i);
                Thread.sleep(1000L);
        }
        System.out.print("""
               
               █▀▀ █▀█ █
               █▄█ █▄█ ▄
                """);
    }

        static void GameRound() throws IOException, InterruptedException {
        while (roundNumber<11){
            //Placement of a new beaver,screen refresh and display of the board
            BoardManagement.BeaverPlacement();
            System.out.print("\033[H\033[2J");
            System.out.println(hitFeedback);
            System.out.println("\n  **** Round " + roundNumber + " of 10 ****\n");
            BoardManagement.BoardDisplay();

            //user input in Bufferreader + counter increment to count number of rounds
            System.out.println("Where is the Beaver?!");
            roundNumber++;
            System.out.println("Enter x, then y");
            BufferedReader inx = new BufferedReader(new InputStreamReader(System.in));

            //while loop that keep the round going for roundtime * a tenth of a second or when inputs are ready
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < roundTime * 100 &&
                    !inx.ready()) {}

            //when coordinates are entered if is executed
                if (inx.ready())
                {
                    String input = inx.readLine();
                    if (input.contains(" ")) {
                        String[] xAndY = input.split(" ");
                        x_coordinate = xAndY[0];
                        y_coordinate = xAndY[1];
                    }
                    //controls that entered data are numbers
                    try {Integer.parseInt(x_coordinate + y_coordinate);
                    }
                    catch(NumberFormatException N){
                        hitFeedback="invalid coordinates, please enter a numerical value";
                        GameRound();
                    }
                    finally {
                        if (Integer.parseInt(x_coordinate )- 1 == BoardManagement.previousX && Integer.parseInt(y_coordinate )- 1 == BoardManagement.previousY)
                        {
                            DisplayMenu.scoreManager.incrementScore();
                            hitFeedback="It's a hit! Current score: " + DisplayMenu.scoreManager.getCurrentScore();

                        }
                        else
                        {
                            hitFeedback="You missed! Current score: " + DisplayMenu.scoreManager.getCurrentScore();

                        }
                        GameRound();
                    }
                }

                //executes when no coordinates are entered for x or y
                    else
                    {
                        hitFeedback=("No coordinates where entered");
                        GameRound();
                    }
            }

                Endgame();
        }


    static void Endgame() throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        DisplayMenu.scoreManager.sort();
        DisplayMenu.scoreManager.endScreen();
        System.out.print("Play again? Y/N ");
        String input = scan.nextLine();
        while (!(input.equals("Y") || input.equals("N") || input.equals("y") || input.equals("n"))) {
            System.out.print("Invalid command\nPlay again? Y/N ");
            input = scan.nextLine();
        }
        if (input.equals("N") || input.equals("n")) {
            DisplayMenu.displayMenu();
        } else if (input.equals("Y")) {
            roundNumber = 0;
            GameCount();
            GameRound();
        }


    }
}