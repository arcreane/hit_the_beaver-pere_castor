import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class HighScore {

    private ArrayList<Score> scores;

    public HighScore() {
        this.scores = new ArrayList<>();
    }

    public void savedScores() {
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

    public void save(String name, int score) {
        this.scores.add(new Score(name, score));

    }

}

