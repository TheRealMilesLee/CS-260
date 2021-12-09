package edu.truman.li.cs260.gui;

/**
 * The type Computer player.
 */
public class CompPlayer extends Player
{
  private int index;
  /**
   * Computer change board.
   *
   * @param boardArray the board array
   */
  public int ComputerChangeBoard (Integer[] boardArray)
  {
    // If the center is empty, place computer chess on the center
    if (boardArray[4] == 0)
    {
      boardArray[4] = 2;
      index = 4;
    }
    else if (boardArray[4] == 1)
    {
      if (boardArray[0] == 1 && boardArray[8] == 0)
      {
        boardArray[8] = 2;
        index = 8;
      }
      else if (boardArray[1] == 1 && boardArray[7] == 0)
      {
        boardArray[7] = 2;
        index = 7;
      }
      else if (boardArray[3] == 1 && boardArray[5] == 0)
      {
        boardArray[5] = 2;
        index = 5;
      }
      else if (boardArray[3] == 0 && boardArray[5] == 1)
      {
        boardArray[3] = 2;
        index = 3;
      }
      else if (boardArray[7] == 1 && boardArray[1] == 0)
      {
        boardArray[1] = 2;
        index = 1;
      }
      else if (boardArray[8] == 1 && boardArray[0] == 0)
      {
        boardArray[0] = 2;
        index = 0;
      }
      else if (boardArray[6] == 1 && boardArray[7] == 0 && boardArray[8] == 1)
      {
        boardArray[7] = 2;
        index = 7;
      }
      else if (boardArray[0] == 2 && boardArray[1] == 0 && boardArray[2] == 2)
      {
        boardArray[1] = 2;
        index = 1;
      }
      else
      {
        Find(boardArray);
      }
    }
    else
    {
      if (boardArray[6] == 1 && boardArray[7] == 0 && boardArray[8] == 1)
      {
        boardArray[7] = 2;
        index = 7;
      }
      else if (boardArray[3] == 2 && boardArray[4] == 2 && boardArray[5] == 0)
      {
        boardArray[5] = 2;
        index = 5;
      }
      else if (boardArray[7] == 1 && boardArray[8] == 1 && boardArray[6] == 0)
      {
        boardArray[6] = 2;
        index = 6;
      }
      else if (boardArray[6] == 1 && boardArray[7] == 1 && boardArray[8] == 0)
      {
        boardArray[8] = 2;
        index = 8;
      }

      else if (boardArray[2] == 1 && boardArray[8] == 1 && boardArray[5] == 0)
      {
        boardArray[5] = 2;
        index = 5;
      }

      else if (boardArray[0] == 1 && boardArray[1] == 0 && boardArray[3] == 0 && boardArray[6] == 1)
      {
        boardArray[3] = 2;
        index = 3;
      }
      else if (boardArray[0] == 1 && boardArray[2] == 1 && boardArray[6] == 1 && boardArray[5] == 0)
      {
        boardArray[5] = 2;
        index = 5;
      }
      else if (boardArray[2] == 1 && boardArray[1] == 1 && boardArray[0] == 0)
      {
        boardArray[0] = 2;
        index = 0;
      }
      else if (boardArray[7] == 2 && boardArray[4] == 2 && boardArray[1] == 0)
      {
        boardArray[1] = 2;
        index = 1;
      }
      else if (boardArray[0] == 1 && boardArray[1] == 0 && boardArray[2] == 1)
      {
        boardArray[1] = 2;
        index = 1;
      }
      else if (boardArray[1] == 2 && boardArray[4] == 2 && boardArray[7] == 0)
      {
        boardArray[7] = 2;
        index = 7;
      }
      else if (boardArray[0] == 0 && boardArray[3] == 1 && boardArray[6] == 1)
      {
        boardArray[0] = 2;
        index = 0;
      }
      else
      {
        Find(boardArray);
      }
    }
    return index;
  }
  
  private void Find (Integer[] boardArray)
  {
    boolean done = false;
    int rightDiagonal = 2;
    //Right Diagonal
    while (rightDiagonal < 9 && !done)
    {
      if (boardArray[rightDiagonal] == 0)
      {
        boardArray[rightDiagonal] = 2;
        index = rightDiagonal;
        done = true;
      }
      else
      {
        rightDiagonal += 2;
      }
    }
  
    // Left Diagonal
    for (int leftDiagonal = 8; leftDiagonal >= 0 && !done; leftDiagonal -= 4)
    {
      if (boardArray[0] == 0 && boardArray[3] == 1 && boardArray[6] == 1)
      {
        boardArray[0] = 2;
        done = true;
      }
      else if (boardArray[leftDiagonal] == 0)
      {
        boardArray[leftDiagonal] = 2;
        index = leftDiagonal;
        done = true;
      }
    }
  
    // Column 3
    for (int Column = 2; Column < 9 && !done; Column += 3)
    {
      if (boardArray[Column] == 0)
      {
        boardArray[Column] = 2;
        index = Column;
        done = true;
      }
    }
  
    // Row Total
    for (int row = 0; row < 9 && !done; row++)
    {
      if (boardArray[row] == 0)
      {
        boardArray[row] = 2;
        index = row;
        done = true;
      }
    }
  }
}
