import java.util.ArrayList;

public class JBot extends Player {

    
    public JBot(String name , String strategy) {
        super(name);
        this.strategy = strategy;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore){
        return true;
    }


}