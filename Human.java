public class Human extends Player {
    private int score;
    private int handScore;
    Final int WIN_SCORE = 100;

    public Bot(String name) {
        super(name , "Human");
        score = 0, handScore = 0;
    }
    
    public void roll(){
        double roll = Math.random();
        System.out.println(roll);
    }

}   