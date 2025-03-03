public class Bot extends Player {
    private int score;
    private int handScore;
    final int WIN_SCORE = 100;
    
    public Bot(String name , String strategy) {
        super(name , strategy);
        score = 0, handScore = 0;
    }

    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore){
        
    }

}