import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GameLoop {
    static String x_coordinate;
    static String y_coordinate;
    static int score = 0;
    static int roundNumber = 0;

    public GameLoop() {
    }

    static void GameCount() throws IOException {


        DisplayMenu.scoreManager.reset();

        //3 sec timer before game start
        System.out.println("get ready");

        int i;
        for (i = 0; i < 3; ++i) {
            System.out.println(3 - i);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }
    }

        static void GameRound() throws IOException {
            BoardManagement.BeaverPlacement();
            BoardManagement.BoardDisplay();

            System.out.println("Where is the Beaver?!");


            int x = 6;

            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

            long startTime = System.currentTimeMillis();
            while ((System.currentTimeMillis() - startTime) < x * 1000 &&
                    !in.ready()) {
            }
            String[] coordinates_input=new String[2];



            if (in.ready())
            {

                coordinates_input = in.readLine().split(" ");

                x_coordinate = coordinates_input[0];
                y_coordinate = coordinates_input[1];

                if (Integer.parseInt(x_coordinate) - 1 == BoardManagement.previousX && Integer.parseInt(y_coordinate) - 1 == BoardManagement.previousY)
                {
                    System.out.println("It's a hit!");
                    DisplayMenu.scoreManager.incrementScore();
                    roundNumber++;
                }
                else
                {
                    System.out.println("You missed!");
                    roundNumber++;

                }
                GameRound();
            }
            else
            {
                System.out.println("you did not enter data");
                GameRound();
                roundNumber++;
            }
        }
}


    /*static void Endgame() {
        DisplayMenu.scoreManager.endScreen();
        System.out.print("Play again? Y/N");
        String input = scan.nextLine();
        while (!(input.equals("Y") || !(input.equals("Y")))) {
            System.out.println("Invalid command");
            input = scan.nextLine();
        }
        if (input.equals("N")) {
            DisplayMenu.displayMenu();
        }
        else if (input.equals("Y"))  {
            GamePlay();
        }

}*/