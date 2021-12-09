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
  public void displayBoard()
  {
    for (int loop = 0; loop < 9; loop++)
    {
      if(loop == 2 || loop == 5|| loop == 9)
      {
        System.out.println(boardArray[loop]);
      }
      else
      {
        System.out.print(boardArray[loop]);
      }
    }
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
  public int ComputerSide()
  {
    int index = 0;
    index = compPlayer.ComputerChangeBoard(boardArray);
    return index;
  }
  
  public void changeBoards(int index)
  {
    boardArray[index] = 1;
  }
  
  public Integer[] getBoards()
  {
    return boardArray;
  }
}
