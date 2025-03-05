// javac PassThePigs.java && java PassThePigs

import java.util.ArrayList;
import java.util.Scanner;

public class PassThePigs {

    static int WIN_SCORE = 100;
    static ArrayList<Player> players = new ArrayList<>();
    static ArrayList<Integer> score = new ArrayList<>();
    static int[] handScore;
    static Scanner sc = new Scanner(System.in);
    static boolean pigOut = false;

    public static void main(String args[]) {

        // initialize players 
        System.out.print("Enter the Number of Bots: ");
        int num = sc.nextInt() + 1;
        sc.nextLine();
        Player jacob = new Human("Jacob");
        for (int i = 0; i < num; i++) {
            players.add((i == 0) ? jacob : new JBot("Player" + (i + 1), "NO BRAIN"));
            score.add(0);
        }

        handScore = new int[num];

        boolean end = false;
        while (!end) {
            for (int i = 0; i < num; i++) {
                if (inGame(i) && players.get(i) instanceof JBot) {
                    botTurn(i);
                } else if (inGame(i)) {
                    humanTurn(i);
                } else {
                    end = true;
                    break;
                }
                pigOut = false;
            }
        }

    }

    public static void botTurn(int i) {
        System.out.print("BOT");
        while (!pigOut && inGame(i) && decidesToRoll(i)) {
            rollPig(i);
            pigOut = (handScore[i] == 0);
        }
    }

    public static void humanTurn(int i) {
        while (!pigOut && inGame(i)) {
            System.out.print("Do You Want To Roll? (y/n)");
            String ans = sc.nextLine();
            if (ans.equals("y")) {
                System.out.println("Rolled");
                rollPig(i);
                pigOut = (handScore[i] == 0);
            } else {
                break;
            }
        }
    }

    public static boolean inGame(int i) {
        return score.get(i) < WIN_SCORE;
    }

    public static boolean decidesToRoll(int i) {
        return players.get(i).wantsToRoll(score.get(i), handScore[i], score, WIN_SCORE);
    }

    public static void rollPig(int i) {
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
