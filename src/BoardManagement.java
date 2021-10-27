public class BoardManagement {

    //Function to create and fill the table depending on specified height and width
    static String[][] BoardGeneration(int height, int width){
        String[][] gameTable = new String[height][width];
        for(int i = 0; i < gameTable.length; i++)
        {
            for(int j = 0; j<gameTable[i].length; j++)
            {
                gameTable[i][j] = "0";
            }
        }

        return gameTable;
    }

    //Function wish displays gameBoard in grid with indexes
    static void BoardDisplay(String[][] gameTable){
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

    }
}
