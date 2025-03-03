import java.util.ArrayList;

public class Human extends Player {
    private int score;
    private int handScore;
    final int WIN_SCORE = 100;

    public Human(String name) {
        super(name , "Human");
        score = 0; handScore = 0;
    }
    
    public void roll(){
        double roll = Math.random();
        System.out.println(roll);
    }

}   