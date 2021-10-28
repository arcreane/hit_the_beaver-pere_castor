import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HighScore {

    private ArrayList<Score> scores;
    private int points;
    private Scanner scan;

    // Class constructor that takes Scanner as parameter avoiding new instance.
    public HighScore(Scanner scan) {
        this.points = 0;
        this.scores = new ArrayList<>();
        this.scan = scan;
    }

    // Method that reads saved scores from file.
    public void importSavedScores() {
        try (Scanner reader = new Scanner(Paths.get("scores.txt"))) {
            while (reader.hasNextLine()) {
                String[] lines = reader.nextLine().split(",");
                this.scores.add(new Score(lines[0], Integer.valueOf(lines[1])));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    // Displays high scores.
    public void getScores() {
        System.out.println("************* HIT THE BEAVER ************");
        System.out.println("************** HALL OF FAME *************\n***\n***");

        for (Score i : this.scores) {
            System.out.println("***  " + i);
        }
    }

    // Increments score by 1, 2 or 3 depending on difficulty.
    public void incrementScore(String playerChoiceDifficulty ) {
        int multiplier = Integer.valueOf(playerChoiceDifficulty);
        if (this.points == 0)  {
            this.points++;
        }
        this.points += this.points*multiplier;
    }

    // Displays score and asks for name if user is in top 5.
    public void endScreen() {
        System.out.println("************* HIT THE BEAVER ************");
        System.out.println("******** Your score: " + this.getCurrentScore());
        System.out.println("******");

        if (this.getCurrentScore() > this.scores.get(0).getPoints())  {
            System.out.println("****** NEW HIGH SCORE!!! ********");

        }

        if (this.getCurrentScore() >= this.scores.get(4).getPoints())  {
            System.out.print("Input name to enter Hall of Fame: ");
            String name = scan.nextLine();
            this.add(name, this.getCurrentScore());
            this.sort();
            this.getScores();
        }

    }

    public void add(String name, int score) {
        this.scores.add(new Score(name, score));
    }

    public void save() {
        try {
            FileWriter fw = new FileWriter("scores.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (Score i : this.scores) {
                bw.write(i.getName() + "," + i.getPoints() + "\n");
            }
            System.out.println("Score successfully added.");
            bw.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void reset()  {
        this.points = 0;
    }

    public void sort() {
        Collections.sort(this.scores);
    }

    public int getCurrentScore()  {
        return this.points;
    }
}