
public class Human extends Player {

    private int handScore;
    final int WIN_SCORE = 100;
    final private Object[][] outcomes = {{"Dot", 0}, {"NoDot", 0},
    {"Razorback", 5}, {"Trotter", 5},
    {"Snouter", 10}, {"Leaning Jowler", 15}};

    public Human(String name) {
        super(name, "Human");
        handScore = 0;
    }

    public String calcResult() {
        int firstRoll = roll();
        int secondRoll = roll();
        System.out.println(firstRoll + " " + secondRoll);
        if (firstRoll + secondRoll == 1) {
            handScore = 0;
            return "Pig Out!";
        }
        int score = (int) outcomes[firstRoll][1] + (int) outcomes[secondRoll][1];
        String output = (String) outcomes[firstRoll][0] + " " + (String) outcomes[secondRoll][0];
        if (firstRoll == secondRoll) {
            score = (firstRoll > 1) ? score * 2 : 1;
            output = "Double " + outcomes[firstRoll][0];
        }
        handScore += score;
        return output;
    }

    private int roll() {
        double roll = Math.random() * 100;
        double[] probList = {34.9, 30.2, 22.4, 8.8, 3.0};
        double prob = 0;
        for (int i = 0; i < 5; i++) {
            prob += probList[i];
            if (roll <= prob) {
                return i;
            }
        }
        System.out.println(roll);
        return 5;
    }

    public int getHandScore(){
        return handScore;
    }

}  
