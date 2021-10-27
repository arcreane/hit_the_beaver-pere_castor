import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class HighScore {

    private ArrayList<Score> scores;

    public HighScore() {
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
        for (Score i : this.scores) {
            System.out.println(i);
        }
    }

    public void add(String name, int score) {
        this.scores.add(new Score(name, score));

    }

    public void save() {

        try {
            FileWriter fw = new FileWriter("scores.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            for (Score i : this.scores)  {
                bw.write(i.getName() + "," + i.getPoints());
            }

            System.out.println("Scores successfully saved.");
            bw.close();

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    public void sort() {
        Collections.sort(this.scores);
    }
}