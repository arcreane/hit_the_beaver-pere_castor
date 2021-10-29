
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
        if (this.name.length() < 4) {
            return this.name + "\t\t\t" + this.points;
        } else {
            return this.name + "\t\t" + this.points;
        }
    }

    @Override
    public int compareTo(Object compared) {
        int comparedScore = ((Score) compared).getPoints();
        return comparedScore-this.getPoints();
    }
}