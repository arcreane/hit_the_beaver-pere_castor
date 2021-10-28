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
    private boolean firstRun;

    // Class constructor.
    public HighScore(Scanner scan) {
        this.points = 0;
        this.scores = new ArrayList<>();
        this.scan = scan;
        this.firstRun = true;
    }

    // Method that reads saved scores from file.
    public void importSavedScores() {
        if (firstRun) {
            try (Scanner reader = new Scanner(Paths.get("scores.txt"))) {
                while (reader.hasNextLine()) {
                    String[] lines = reader.nextLine().split(",");
                    this.scores.add(new Score(lines[0], Integer.valueOf(lines[1])));
                }

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        firstRun = false;
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
    public void incrementScore() {
        this.points++;
    }

    // Displays score and asks for name if user is in top 5.
    public void endScreen() {
        System.out.println("************* HIT THE BEAVER ************");
        System.out.println("******** Your score: " + this.getCurrentScore());
        System.out.println("******");

        if (this.getCurrentScore() > this.scores.get(0).getPoints())  {
            System.out.println("****** NEW HIGH SCORE!!! ********");

        }

        if (this.getCurrentScore() > this.scores.get(4).getPoints())  {
            System.out.print("Input name to enter Hall of Fame: ");
            String name = scan.nextLine();
            this.add(name, this.getCurrentScore());
            this.sort();
            this.getScores();
        }

    }
    // Adds new score
    public void add(String name, int score) {
        this.scores.add(new Score(name, score));
    }

    // Saves scores to txt file upon closing game.
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

    // Resets score for next round.
    public void reset()  {
        this.points = 0;
    }

    // Sorts scores from hightest to lowest.
    public void sort() {
        Collections.sort(this.scores);
    }

    // Returns score for current game.
    public int getCurrentScore()  {
        int multiplier = Integer.valueOf(Difficulty.playerChoiceDifficulty);
        return this.points * multiplier;
    }
}