import java.util.ArrayList;

public class JBot extends Player {
    private int handScore;
    final int WIN_SCORE = 100;
    
    public JBot(String name , String strategy) {
        super(name , strategy);
        score = 0; handScore = 0;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore){
        
    }

}