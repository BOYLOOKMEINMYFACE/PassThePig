
public class Pig{
    public static Object[][] OUTCOMES = {{"Dot", 0}, {"NoDot", 0},
    {"Razorback", 5}, {"Trotter", 5},
    {"Snouter", 10}, {"Leaning Jowler", 15}};

    public static String calcPose(int firstRoll , int secondRoll) {
        if (firstRoll + secondRoll == 1) {
            return "Pig Out!";
        }
        String output = (String) OUTCOMES[firstRoll][0] + " " + (String) OUTCOMES[secondRoll][0];
        if (firstRoll == secondRoll) {
            output = "Double " + OUTCOMES[firstRoll][0];
        }
        return output;
    }

    public static int calcScore(int firstRoll , int secondRoll){
        if (firstRoll + secondRoll == 1) {
            return 0;
        }
        int score = (int) OUTCOMES[firstRoll][1] + (int) OUTCOMES[secondRoll][1];
        if (firstRoll == secondRoll) {
            score = (firstRoll > 1) ? score * 2 : 1;
        }
        return score;
    }


    public static int roll() {
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

    
}