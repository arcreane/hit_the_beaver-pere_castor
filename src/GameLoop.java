import java.util.Scanner;

public class GameLoop {

    static void GamePlay() {

        Scanner scan = new Scanner(System.in);

        DisplayMenu.scoreManager.reset();

        //3 sec timer before game start
        System.out.println("get ready");
        for (int i = 0; i<3; i++){
            System.out.println(3-i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //game loops for ten rounds, missing the timer for each rounds
        for (int i=0; i<10; i++){
            BoardManagement.BeaverPlacement();
            BoardManagement.BoardDisplay();
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Where is the Beaver?!
                    Enter x  and y coordinates :
                    """);
            //player inputs
            int x_coordinate = scanner.nextInt();
            int y_coordinate = scanner.nextInt();

            //controlling if player inputs==beaver placement and score increment
            if (x_coordinate-1 == BoardManagement.previousX && y_coordinate-1 == BoardManagement.previousY)
            {
                System.out.println("It's a hit!");
                DisplayMenu.scoreManager.incrementScore(Difficulty.playerChoiceDifficulty);

            }
            else
            {
                System.out.println("You missed!");
            }

        }
        DisplayMenu.scoreManager.endScreen();
    }
}