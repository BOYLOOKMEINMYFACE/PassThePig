// javac PassThePigs.java && java PassThePigs

import java.util.ArrayList;
import java.util.Scanner;

public class PassThePigs {

    static Scanner sc = new Scanner(System.in);

    static int WIN_SCORE = 100;
    static ArrayList<Player> players;
    static ArrayList<Integer> score;
    static int[] handScore;
    static boolean pigOut;
    static int num;

    public static void main(String args[]) {

        boolean playAgain = true;
        while (playAgain) {
            initialize();
            playGame();

            // check if wants to replay
            System.out.print("Do you want to play again? (y/n)");
            if (!sc.nextLine().equals("y")) {
                playAgain = !playAgain;
            }
        }

    }

    public static void initialize() {
        // choose number of bots in game
        System.out.println("Welcome to PassThePigs! Are YOU ready to pass pigs?");
        System.out.print("Enter the Number of Bots: ");
        num = sc.nextInt() + 1;
        sc.nextLine();
        handScore = new int[num];

        // setup scores and players
        pigOut = false;
        players = new ArrayList<>();
        score = new ArrayList<>();
        Player jacob = new Human("Jacob");
        for (int i = 0; i < num; i++) {
            players.add((i == 0) ? jacob : new JBot("Player" + (i + 1), "NO BRAIN"));
            score.add(0);
        }
    }

    public static void playGame() {
        while (true) {
            playOneRound();
        }
    }

    public static void playOneRound() {
        for (int i = 0; i < num; i++) {
            if (inGame(i) && players.get(i) instanceof JBot) { // when the player is a bot
                System.out.println("________________");
                System.out.println(players.get(i).getName() + "'s turn!");
                botTurn(i);
            } else if (inGame(i)) { // when the player is a human
                System.out.println("Your turn! Let's pass the pig!");
                humanTurn(i);
            }
            if (!inGame(i)) { // when there is a winner
                String winner = (i == 0) ? "You" : players.get(i).getName();
                System.out.println("Game Over! " + winner + " Won!");
                break;
            }
            pigOut = false;
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
            if (sc.nextLine().equals("y")) {
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

    // roll twice and compare based on the combination
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
