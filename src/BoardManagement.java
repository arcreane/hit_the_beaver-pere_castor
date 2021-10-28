import com.sun.jdi.IntegerValue;

public class BoardManagement {
    static int dimension = 0;
    static String[][] gameBoard;
    static int previousX = -1;
    static int previousY = -1;

    //Function to create and fill the table depending on specified dimension depending on difficulty

    static void BoardGeneration(String playerChoiceDifficulty){

        if (playerChoiceDifficulty.equals("1"))
            dimension = 5;
        else if (playerChoiceDifficulty.equals("2"))
            dimension = 7;
        else
            dimension = 10;
        gameBoard = new String[dimension][dimension];
        for(int i = 0; i < dimension; i++)
        {
            for(int j = 0; j<dimension; j++)
            {
                gameBoard[i][j] = " ";
            }
        }
    }

    //Function which displays gameBoard in grid with indexes
    static void BoardDisplay(){
        //print tableau avec indexes

        //index x
        System.out.print("   ");
        for(int i =0; i < dimension ; i++){
            System.out.print(" " + (i+1));
        }

        System.out.print("\n   ");
        for(int i =0; i < dimension ; i++){
            System.out.print(" _");
        }

        //index y + gameBoard content
        for(int i = 0; i < dimension; i++){
            if (i >= 9){
                System.out.print("\n"+ (i+1) + "|");
            }
            else {
                System.out.print("\n "+ (i+1) + "|");
            }
            for(int j = 0; j<dimension; j++)
                System.out.print(" " + gameBoard[i][j]);
        }
        System.out.println();
    }

    /*
    function which place a new Beaver in Gameboard at random coordinates and delete the previous one
    if any.To be initialized with int[] previousCoordinates = {-1, -1} so the function doesn't search
    for a Beaver when there is none.
    */
    static void BeaverPlacement(){
        if (previousX == -1){
            int x = (int)(Math.random()*(dimension));
            int y = (int)(Math.random()*(dimension));
            gameBoard[y][x]="B";
            previousY = y;
            previousX = x;
        }
        else {
            gameBoard[previousY][previousX]=" ";
            int x = (int)(Math.random()*(dimension));
            int y = (int)(Math.random()*(dimension));
            gameBoard[y][x]="B";
            previousY = y;
            previousX = x;
        }
    }
}
