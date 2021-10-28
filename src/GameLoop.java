import java.util.Scanner;

public class GameLoop {
    static int x_coordinate;
    static int y_coordinate;
    static int score = 0;

    public GameLoop() {
    }

    static void GamePlay() {
        //3 sec timer before game start
        System.out.println("get ready");

        int i;
        for(i = 0; i < 3; ++i) {
            System.out.println(3 - i);

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException var2) {
                var2.printStackTrace();
            }
        }
        //game loops for ten rounds, missing the timer for each rounds
        for(i = 0; i < 10; ++i) {
            BoardManagement.BeaverPlacement();
            BoardManagement.BoardDisplay();
            Scanner scanner = new Scanner(System.in);
            // Here we ask the player for the beaver location
            System.out.println("Where is the Beaver?!\nEnter numerical x and y coordinates, separated by a space:\n");
            System.out.println("Where is the Beaver?!");

            System.out.println("Enter numerical x coordinate value : ");
            while(!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
            x_coordinate = scanner.nextInt();

            System.out.println("Enter numerical y coordinate value : ");
            while(!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number");
                scanner.next();
            }
            y_coordinate = scanner.nextInt();

            //controlling if player inputs==beaver placement and score increment
            if (x_coordinate - 1 == BoardManagement.previousX && y_coordinate - 1 == BoardManagement.previousY) {
                System.out.println("It's a hit!");
                ++score;
            } else {
                System.out.println("You missed!");
            }

            System.out.println("score=" + score);
        }

    }
}