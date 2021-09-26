package com.edu.truman.li.cs260;

public class PlayTheGame
{
  public void Game (Board chessBoardObject)
  {
    boolean WinnerDecided = false;
    for(int fillPlate = 0; fillPlate < 5 && !WinnerDecided; fillPlate++)
    {
      chessBoardObject.HumanChangeBoard();
      chessBoardObject.DisplayBoard();
      System.out.println("Computer make its move");
      chessBoardObject.ComputerChangeBoard();
      chessBoardObject.DisplayBoard();
      if(chessBoardObject.JudgeWinner().equals("Human") || chessBoardObject.JudgeWinner().equals("Computer"))
      {
        System.out.println("We have a winner! The winner is: " + chessBoardObject.JudgeWinner());
        WinnerDecided = true;
      }
      
    }
    System.out.println("Continue? (Press q to quit the game) ");
  }
}

