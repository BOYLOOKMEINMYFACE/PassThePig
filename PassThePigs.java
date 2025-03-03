import java.util.Scanner;

public class PassThePigs{
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Player jacob = new Human("Jacob");

        ((Human)jacob).roll();
    }
}