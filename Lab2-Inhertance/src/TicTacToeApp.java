import com.edu.truman.li.cs260.Board;
import com.edu.truman.li.cs260.PlayTheGame;
import java.util.*;

public class TicTacToeApp {
  public static void main (String[] args) {
    PlayTheGame gameObject = new PlayTheGame();
    Board HumanSideObject = new Board();
    Board ComputerSideObject = new Board();
    Scanner continuePlayFlag = new Scanner(System.in);
    //Show the board and the direction of the game
    HumanSideObject.Direction();
    //Game Begin
    System.out.println("Game Start! ");
    boolean GameEnd = false;
    while (!GameEnd)
    {
      System.out.println("Human Side choice! ");
      gameObject.HumanSideGame(HumanSideObject);
      String GameEndFlag = continuePlayFlag.next();
      if (GameEndFlag.equals("q") || GameEndFlag.equals("Q"))
      {
        GameEnd = true;
      }
      else
      {
        System.out.println("Computer Side choice! ");
        gameObject.ComputerSideGame(ComputerSideObject);
        GameEndFlag = continuePlayFlag.next();
        if (GameEndFlag.equals("q") || GameEndFlag.equals("Q"))
        {
          GameEnd = true;
        }
      }
    }
  }
}

