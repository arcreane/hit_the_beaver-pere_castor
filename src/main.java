import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        while (true) {



            DisplayMenu.displayMenu();

            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    Where is the Beaver?!
                    Enter x  and y coordinates : 
                    """);
            int x_coordinate = scanner.nextInt();
            int y_coordinate = scanner.nextInt();

            System.out.print("x : " + x_coordinate + ", y : " + y_coordinate);


        }


    }
}
