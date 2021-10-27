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

    public HighScore(Scanner scan) {
        this.scan = scan;
        this.points = 0;
        this.scores = new ArrayList<>();
    }

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

    public void getScores() {
        System.out.println("************* HIT THE BEAVER ************");
        System.out.println("************** HALL OF FAME *************\n***\n***");

        for (Score i : this.scores) {
            System.out.println("***  " + i);
        }
    }

    public void incrementScore(int points) {
        this.points += (points);
    }

    public void endScreen(Scanner scan) {
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

    public void sort() {
        Collections.sort(this.scores);
    }

    public int getCurrentScore()  {
        return this.points;
    }

}