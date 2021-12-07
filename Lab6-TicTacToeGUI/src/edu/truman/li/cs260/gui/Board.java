package edu.truman.li.cs260.gui;

import java.util.Arrays;

/**
 * The type edu.truman.li.cs260.gui.Board.
 */
public class Board
{
  /**
   * The edu.truman.li.cs260.gui.Board array.
   */
  protected Integer[] boardArray;
  /**
   * The Computer object.
   */
  CompPlayer compPlayer = new CompPlayer();
  
  /**
   * Instantiates a new edu.truman.li.cs260.gui.Board.
   */
  public Board()
  {
    boardArray = new Integer[9];
    Arrays.fill(boardArray, 0);
  }
  
  /**
   * Clear board.
   */
  public void clearBoard()
  {
    Arrays.fill(boardArray, 0);
  }
  
  /**
   * Computer side change board.
   */
  public void ComputerSide()
  {
    compPlayer.ComputerChangeBoard(boardArray);
  }
  
  
  /**
   * Judge winner string.
   * @return the string used to output the winner
   */
  public String JudgeWinner()
  {
    String Winner = "";
    if ((boardArray[0] + boardArray[1] + boardArray[2] == 3) ||
        (boardArray[3] + boardArray[4] + boardArray[5] == 3) ||
        (boardArray[6] + boardArray[7] + boardArray[8] == 3) ||
        (boardArray[0] + boardArray[4] + boardArray[8] == 3) ||
        (boardArray[2] + boardArray[4] + boardArray[5] == 3) ||
        (boardArray[0] + boardArray[3] + boardArray[6] == 3) ||
        (boardArray[1] + boardArray[4] + boardArray[7] == 3) ||
        (boardArray[2] + boardArray[5] + boardArray[8] == 3))
    {
      Winner = "Human";
    }
    else if ((boardArray[0] + boardArray[1] + boardArray[2] == 0) ||
            (boardArray[3] + boardArray[4] + boardArray[5] == 0) ||
            (boardArray[6] + boardArray[7] + boardArray[8] == 0) ||
            (boardArray[0] + boardArray[4] + boardArray[8] == 0) ||
            (boardArray[2] + boardArray[4] + boardArray[5] == 0) ||
            (boardArray[0] + boardArray[3] + boardArray[6] == 0) ||
            (boardArray[1] + boardArray[4] + boardArray[7] == 0) ||
            (boardArray[2] + boardArray[5] + boardArray[8] == 0))
    {
      Winner = "Computer";
    }
    else
    {
      Winner = "Tie";
    }
    return Winner;
  }
}
