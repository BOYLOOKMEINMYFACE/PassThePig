
import java.util.Scanner;

public class PassThePigs {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Player jacob = new Human("Jacob");
        
        System.out.println(((Human) jacob).calcResult());
        System.out.println(((Human) jacob).getHandScore());
    }
}
