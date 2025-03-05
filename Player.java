
import java.util.ArrayList;

public class Player {

    private String name;
    private String strategy;

    public Player(String name, String strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return true;
    }

    public String getName() {
        return "W";
    }

    public String getStrategy() {
        return "W";
    }
}
