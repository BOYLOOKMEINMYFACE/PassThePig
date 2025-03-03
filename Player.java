public class Player{
    private String name;
    private String strategy;

    public Player(String name , String strategy){
        this.name = name;
        this.strategy = strategy;
    }
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore){
        return true;
    }
    public String getName(){
        
    }
    public String getStrategy(){

    }
}