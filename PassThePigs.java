
import java.util.ArrayList;
import java.util.Scanner;


public class PassThePigs {

    public static void main(String args[]) {

        int WIN_SCORE = 100;
        Scanner sc = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();
        ArrayList<Integer> score = new ArrayList<>();

        // initialize players 
        System.out.print("Enter the Number of Bots: ");
        int num = sc.nextInt() + 1;
        Player jacob = new Human("Jacob");
        for (int i = 0; i < num; i++) {
            players.add((i == 0) ? jacob : new JBot("Player" + (i + 1), "NO BRAIN"));
            score.add(0);
        }

        int[] handScore = new int[num];

        for (int i = 0; i < num; i++) {
            boolean pigOut = false;
            while (!pigOut && score.get(i) < WIN_SCORE && players.get(i).wantsToRoll(score.get(i), handScore[i], score, WIN_SCORE)) {
                int firstRoll = Pig.roll();
                int secondRoll = Pig.roll();
                System.out.println(Pig.calcPose(firstRoll, secondRoll));
                handScore[i] = Pig.calcScore(score.get(i), firstRoll, secondRoll);
            }
        }

    }

}
