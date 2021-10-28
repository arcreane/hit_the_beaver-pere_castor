
public class Score implements Comparable {

    private String name;
    private int points;

    public Score(String name, int points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return this.name;
    }

    public int getPoints() {
        return this.points;
    }

    @Override
    public String toString() {
        return this.name + "\t" + this.points;
    }

    @Override
    public int compareTo(Object compared) {
        int comparedScore = ((Score) compared).getPoints();
        return comparedScore-this.getPoints();
    }
}