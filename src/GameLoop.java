import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameLoop {
    static String x_coordinate;
    static String y_coordinate;
    static int roundNumber = 1;
    static int roundTime = 4;

    public GameLoop() {
    }

    static void GameCount() throws IOException, InterruptedException {


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
            System.out.println("\n  *** Round " + roundNumber + " ***\n");
            BoardManagement.BoardDisplay();

            //user input in Bufferreader + counter increment to count number of rounds
            System.out.println("Where is the Beaver?!");
            roundNumber++;
            System.out.println("Enter x then y");
            BufferedReader inx = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader iny = new BufferedReader(new InputStreamReader(System.in));

            //while loop that keep the round going for roundtime * a tenth of a second or when inputs are ready
            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < roundTime * 100 &&
                    !inx.ready() && !iny.ready())
            {
            }


            //when coordinates are entered if is executed
                if (inx.ready() && iny.ready())
                {
                    x_coordinate = inx.readLine();
                    y_coordinate = iny.readLine();
                    //controls that entered data are numbers
                    try {Integer.parseInt(x_coordinate);
                    }
                    catch(NumberFormatException N){
                        System.out.println("invalid coordinates please enter only numbers");
                        GameRound();
                    }
                    finally {
                        if (Integer.parseInt(x_coordinate )- 1 == BoardManagement.previousX && Integer.parseInt(y_coordinate )- 1 == BoardManagement.previousY)
                        {
                            System.out.println("It's a hit!");
                            DisplayMenu.scoreManager.incrementScore();
                        }
                        else
                        {
                            System.out.println("You missed!");

                        }
                        GameRound();

                    }

                }
                //executes when no coordinates are entered for x or y
                    else
                    {
                        System.out.println("you did not enter coordinates");
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