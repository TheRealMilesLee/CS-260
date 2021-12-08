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
  
  public Integer[] getBoards()
  {
    return boardArray;
  }
  
  
}
