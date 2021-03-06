import com.edu.truman.li.cs260.TicTacToe.Board;
import java.util.*;

/**
 * The type Tic tac toe app.
 */
public class TicTacToeApp
{
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main (String[] args)
  {
    Board HumanSideObject = new Board();
    Board ComputerSideObject = new Board();
    Scanner continuePlayFlag = new Scanner(System.in);
    //Show the board and the direction of the game
    HumanSideObject.DisplayBoard();
    HumanSideObject.Direction();
    //Game Begin
    System.out.println("Game Start! ");
    boolean GameEnd = false;
    while (!GameEnd)
    {
      HumanSideObject.clearBoard();
      System.out.println("Human Side choice! ");
      boolean WinnerDecided = false;
      for (int fillPlate = 0; fillPlate < 5 && !WinnerDecided; fillPlate++)
      {
        HumanSideObject.HumanChangeBoard();
        HumanSideObject.DisplayBoard();
        if (HumanSideObject.JudgeWinner().equals("Human") || HumanSideObject.JudgeWinner().equals("Computer"))
        {
          System.out.println("We have a winner! The winner is: " + HumanSideObject.JudgeWinner());
          WinnerDecided = true;
        }
        else
        {
          System.out.println("Computer make its move");
          HumanSideObject.ComputerSide();
          HumanSideObject.DisplayBoard();
          if (HumanSideObject.JudgeWinner().equals("Human") || HumanSideObject.JudgeWinner().equals("Computer"))
          {
            System.out.println("We have a winner! The winner is: " + HumanSideObject.JudgeWinner());
            WinnerDecided = true;
          }
        }
        // Tie situation
        if(HumanSideObject.boardIsFull())
        {
          if(HumanSideObject.JudgeWinner().equals("Tie"))
          {
            System.out.println("There is no Winner! Tie Game");
            WinnerDecided = true;
          }
        }
      }
      System.out.println("Continue? (Press q to quit the game) ");
      String GameEndFlag = continuePlayFlag.next();
      if (GameEndFlag.equals("q") || GameEndFlag.equals("Q"))
      {
        GameEnd = true;
      }
      else
      {
        // Reset the status and clean the board
        WinnerDecided = false;
        ComputerSideObject.clearBoard();

        //Game start
        System.out.println("Computer Side choice! ");
        ComputerSideObject.ComputerSide();
        ComputerSideObject.DisplayBoard();
        for (int ComputerSideRoll = 0; ComputerSideRoll < 5 && !WinnerDecided; ComputerSideRoll++)
        {
          System.out.println("Human change board! ");
          ComputerSideObject.HumanChangeBoard();
          ComputerSideObject.DisplayBoard();
          if (ComputerSideObject.JudgeWinner().equals("Human") || ComputerSideObject.JudgeWinner().equals("Computer"))
          {
            System.out.println("We have a winner! The winner is: " + ComputerSideObject.JudgeWinner());
            WinnerDecided = true;
          }
          else
          {
            System.out.println("Computer make its move");
            ComputerSideObject.ComputerSide();
            ComputerSideObject.DisplayBoard();
            if (ComputerSideObject.JudgeWinner().equals("Human") || ComputerSideObject.JudgeWinner().equals("Computer"))
            {
              System.out.println("We have a winner! The winner is: " + ComputerSideObject.JudgeWinner());
              WinnerDecided = true;
            }
            if(ComputerSideObject.boardIsFull())
            {
              if(ComputerSideObject.JudgeWinner().equals("Tie"))
              {
                System.out.println("There is no Winner! Tie Game");
                WinnerDecided = true;
              }
            }
          }
        }
        System.out.println("Continue? (Press q to quit the game) ");
        GameEndFlag = continuePlayFlag.next();
        if (GameEndFlag.equals("q") || GameEndFlag.equals("Q"))
        {
          GameEnd = true;
        }
      }
    }
  }
}