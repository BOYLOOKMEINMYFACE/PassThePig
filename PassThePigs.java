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
    static int num;

    public static void main(String args[]) {

        // initialize players and Game
        System.out.println("Welcome to PassThePigs! Are YOU ready to pass pigs?");
        System.out.print("Enter the Number of Bots: ");
        num = sc.nextInt() + 1;
        sc.nextLine();
        handScore = new int[num];
        Player jacob = new Human("Jacob");
        for (int i = 0; i < num; i++) {
            players.add((i == 0) ? jacob : new JBot("Player" + (i + 1), "NO BRAIN"));
            score.add(0);
        }

        // Play Game
        boolean end = false;
        while (!end) {
            for (int i = 0; i < num; i++) {
                if (inGame(i) && players.get(i) instanceof JBot) {
                    System.out.println("________________");
                    System.out.println(players.get(i).getName() + "'s turn!");
                    botTurn(i);
                } else if (inGame(i)) {
                    System.out.println("Your turn! Let's pass the pig!");
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
        while (!pigOut && inGame(i) && decidesToRoll(i)) {
            System.out.println(players.get(i).getName() + " rolls!");
            rollPig(i);
            displayStat();
            pigOut = (handScore[i] == 0);
        }
    }

    public static void humanTurn(int i) {
        while (!pigOut && inGame(i)) {
            displayStat();
            System.out.print("Do You Want To Roll? (y/n)");
            String ans = sc.nextLine();
            if (ans.equals("y")) {
                System.out.println("ROLL EM!");
                rollPig(i);
                pigOut = (handScore[i] == 0);
                System.out.println("Your handScore: " + handScore[i]);
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
    }

    public static void displayStat() {
        System.out.println("________________");
        for (int i = 0; i < num; i++) {
            System.out.println(players.get(i).getName() + " Score: " + score.get(i));
        }
        System.out.println("________________");
    }
}
