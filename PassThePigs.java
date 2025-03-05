import java.util.ArrayList;
import java.util.Scanner;

public class PassThePigs {
    final int Win_Score = 100;

    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);

        ArrayList<Player> players = new ArrayList<>();
        Player jacob = new Human("Jacob");
        players.add(jacob);
        
        int num = 10;
        for(int i = 0; i < num; i++){
            players.add(new JBot("Player" + (i+1) , "NO BRAIN"));
        }

        int[] score = new int[players.size()];



    }

    
}
