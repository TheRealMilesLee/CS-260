package com.edu.truman.li.cs260;

public class PlayTheGame
{
  public void HumanSideGame (Board chessBoardObject)
  {
    CoreGame(chessBoardObject);
  }
  
  public void ComputerSideGame (Board chessBoardObject)
  {
    chessBoardObject.ComputerInitialMove();
    chessBoardObject.DisplayBoard();
    CoreGame(chessBoardObject);
  }
  
  public void CoreGame (Board chessBoardObject)
  {
    boolean ComputerSideWinnerDecided = false;
    for(int fillPlate = 0; fillPlate < 5 && !ComputerSideWinnerDecided; fillPlate++)
    {
      chessBoardObject.HumanChangeBoard();
      chessBoardObject.DisplayBoard();
      System.out.println("Computer make its move");
      chessBoardObject.ComputerChangeBoard();
      chessBoardObject.DisplayBoard();
      if(chessBoardObject.JudgeWinner().equals("Human") || chessBoardObject.JudgeWinner().equals("Computer"))
      {
        System.out.println("We have a winner! The winner is: " + chessBoardObject.JudgeWinner());
        ComputerSideWinnerDecided = true;
      }
    }
    System.out.println("Continue? (Press q to quit the game) ");
  }
}

