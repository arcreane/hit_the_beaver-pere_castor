import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class GameLoop {

    static void GamePlay() {

        DisplayMenu.scoreManager.reset();

        //3 sec timer before game start
/*        System.out.println("get ready");
        for (int i = 0; i < 3; i++) {
            System.out.println(3 - i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        //game loops for ten rounds, missing the timer for each rounds
        //for (int i = 0; i < 10; i++) {

            //PlayerTimer.Timer();

            System.out.println("""
                    Where is the Beaver?!
                    Enter x  and y coordinates :
                    """);

            //player inputs

            //Input with a buffer to avoid stopping the timer
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int x_coordinate = 0;
            int y_coordinate = 0;
            try {
                x_coordinate = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                y_coordinate = Integer.parseInt(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            //controlling if player inputs==beaver placement and score increment
            if (x_coordinate - 1 == BoardManagement.previousX && y_coordinate - 1 == BoardManagement.previousY) {
                System.out.println("It's a hit!");
                DisplayMenu.scoreManager.incrementScore();

            } else {
                System.out.println("You missed!");
            }
            DisplayMenu.scoreManager.endScreen();
        }

    }
//}