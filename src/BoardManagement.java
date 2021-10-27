import com.sun.jdi.IntegerValue;

public class BoardManagement {

    static String[][] gameTable;
    //Function to create and fill the table depending on specified height and width
    static void BoardGeneration(int height, int width){
         gameTable = new String[height][width];
        for(int i = 0; i < gameTable.length; i++)
        {
            for(int j = 0; j<gameTable[i].length; j++)
            {
                gameTable[i][j] = " ";
            }
        }
    }

    //Function wish displays gameBoard in grid with indexes
    static void BoardDisplay(){
        //print tableau avec indexes
        int width=gameTable[0].length;

        //index x
        System.out.print("   ");
        for(int i =0; i < width ; i++){
            System.out.print(" " + (i+1));
        }

        System.out.print("\n   ");
        for(int i =0; i < width ; i++){
            System.out.print(" _");
        }

        //index y + gameBoard content
        for(int i = 0; i < gameTable.length; i++){
            if (i >= 9){
                System.out.print("\n"+ (i+1) + "|");
            }
            else {
                System.out.print("\n "+ (i+1) + "|");
            }
            for(int j = 0; j<gameTable[i].length; j++)
                System.out.print(" " + gameTable[i][j]);
        }
        System.out.println();
    }

    /*
    function wish place a new Beaver in Gameboard at random coordinates and delete the previous one
    if any.To be initialized with int[] previousCoordinates = {-1, -1} so the function doesn't search
    for a Beaver when there is none.
    */
    static void BeaverPlacement( int[] previousCoordinates){
        if (previousCoordinates[0] == -1){
            int x = (int)(Math.random()*(gameTable.length));
            int y = (int)(Math.random()*(gameTable[0].length));
            gameTable[y][x]="B";
            previousCoordinates[0] = y;
            previousCoordinates[1] = x;
        }
        else {
            gameTable[previousCoordinates[0]][previousCoordinates[1]]=" ";
            int x = (int)(Math.random()*(gameTable.length));
            int y = (int)(Math.random()*(gameTable[0].length));
            gameTable[y][x]="B";
            previousCoordinates[0] = y;
            previousCoordinates[1] = x;
        }
    }
}
