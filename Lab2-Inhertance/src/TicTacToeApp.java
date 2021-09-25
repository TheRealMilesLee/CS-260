import com.edu.truman.li.cs260.Board;
import com.edu.truman.li.cs260.CompPlayer;
import com.edu.truman.li.cs260.HumanPlayer;
import com.edu.truman.li.cs260.Player;

import java.util.Scanner;

public class TicTacToeApp {
  public static void main(String[] args){
    Board chessBoardObject = new Board();
    CompPlayer computerPlayerObject = new CompPlayer();
    HumanPlayer humanPlayerObject = new HumanPlayer();
    Player playerObject = new Player();
    
    System.out.println("The + indicates that these positions are empty and can be selected by the player. ");
    System.out.println("H stands for the human player move, and C stands for the computer player move.");
    System.out.println("Now, make your move by typing the row and column from 0-2: ");
    Scanner userInput = new Scanner(System.in);
    userInput.nextInt();
    
  }
}
