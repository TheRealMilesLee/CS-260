import edu.truman.cs260.hengyili.lab.Farewell;
import edu.truman.cs260.hengyili.lab.Greeter;
import java.util.Scanner;

public class Speaker {
    public static void main(String[] args){
        System.out.println("Please Enter your name: ");
        Scanner input = new Scanner(System.in);
        String userName = input.nextLine();
        System.out.println("Please Enter a greeting: ");
        String Greeting = input.nextLine();
        System.out.println("Please Enter a farewell: ");
        String FarewellFriend = input.nextLine();

        Greeter greeting = new Greeter(Greeting);
        Farewell farewell = new Farewell(FarewellFriend);
        System.out.println("\n" + greeting.getGreeting() + ", " + userName + "!");
        System.out.println("It is time for you to go, so " + farewell.getFarewell() + "," + userName);
    }
}
