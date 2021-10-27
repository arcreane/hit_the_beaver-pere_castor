public class Score {

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

    public String toString() {
        return this.name + "\t" + this.points;
    }

}
