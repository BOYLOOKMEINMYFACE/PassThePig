import java.util.ArrayList;

public class Human extends Player {

    public Human(String name) {
        super(name);
        strategy = "HUMAN";
    }
    
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore) {
        return true;
    }


}  
