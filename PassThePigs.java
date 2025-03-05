
import java.util.ArrayList;
import java.util.Scanner;

public class PassThePigs {

    static int WIN_SCORE = 100;
    static ArrayList<Player> players = new ArrayList<>();
    static ArrayList<Integer> score = new ArrayList<>();
    static int[] handScore;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        // initialize players 
        System.out.print("Enter the Number of Bots: ");
        int num = sc.nextInt() + 1;
        Player jacob = new Human("Jacob");
        for (int i = 0; i < num; i++) {
            players.add((i == 0) ? jacob : new JBot("Player" + (i + 1), "NO BRAIN"));
            score.add(0);
        }

        handScore = new int[num];

        boolean end = false;
        boolean pigOut = false;
        while (!end) {
            for (int i = 0; i < num; i++) {
                if (score.get(i) < WIN_SCORE) {
                    while (!pigOut && score.get(i) < WIN_SCORE && decidesToRoll(i)) {
                        takeTurn(i);
                        pigOut = (handScore[i] == 0);
                    }
                } else {
                    end = true;
                    break;
                }
                pigOut = false;
            }
        }

    }

    public static boolean decidesToRoll(int i){
        return players.get(i).wantsToRoll(score.get(i), handScore[i], score, WIN_SCORE);
    }

    public static void takeTurn(int i) {
        int firstRoll = Pig.roll(), secondRoll = Pig.roll();
        handScore[i] = Pig.calcScore(firstRoll, secondRoll);
        System.out.println(Pig.calcPose(firstRoll, secondRoll));
        if (handScore[i] == 0) {
            score.set(i, 0);
        } else {
            score.set(i, score.get(i) + handScore[i]);
        }
        System.out.println(score.get(i));
    }
}
