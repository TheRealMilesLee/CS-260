package edu.truman.li.cs260.gui;

/**
 * The type Computer player.
 */
public class CompPlayer extends Player
{
  /**
   * Computer change board.
   * @param boardArray the board array
   */
  public void ComputerChangeBoard (Integer[] boardArray)
  {
    boolean makeChoice = false;
    // If the center is empty, place computer chess on the center
    if (boardArray[4] == 0)
    {
      boardArray[4] = 2;
    }
    else if (boardArray[4] == 1)
    {
      if (boardArray[0] == 1 && boardArray[8] == 0)
      {
        boardArray[8] = 2;
      }
      else if(boardArray[1] == 1 && boardArray[7] == 0)
      {
        boardArray[7] = 2;
      }
      else if(boardArray[3] == 1 && boardArray[5] == 0)
      {
        boardArray[5] = 2;
      }
      else if(boardArray[5] == 1 && boardArray[3] == 0)
      {
        boardArray[3] = 2;
      }
      else if(boardArray[7] == 1 && boardArray[1] == 0)
      {
        boardArray[1] = 2;
      }
      else if(boardArray[8] == 1 && boardArray[0] == 0)
      {
        boardArray[0] = 2;
      }
      else if(boardArray[6] == 1 && boardArray[7] == 0 && boardArray[8] == 1)
      {
        boardArray[7] = 2;
      }
      else if(boardArray[0] == 2 && boardArray[1] == 0 && boardArray[2] == 2)
      {
        boardArray[1] = 0;
      }
      else
      {
        Find(boardArray, makeChoice);
      }
    }
    else
    {
      if (boardArray[6] == 1 && boardArray[7] == 2 && boardArray[8] == 1)
      {
        boardArray[7] = 2;
      }
      else if(boardArray[0] == 1 && boardArray[3] == 0 && boardArray[6] == 1 && (boardArray[7] == 0 || boardArray[8] == 1))
      {
        boardArray[3] = 2;
      }
      else if(boardArray[2] == 1 && boardArray[5] == 0 && boardArray[8] == 1 && boardArray[7] == 0)
      {
        boardArray[5] = 2;
      }
      else if(boardArray[2] == 1 && boardArray[1] == 1 && boardArray[0] == 0)
      {
        boardArray[0] = 2;
      }
      else if(boardArray[7] == 2 && boardArray[4] == 2 && boardArray[1] == 0)
      {
        boardArray[1] = 2;
      }
      else if(boardArray[0] == 1 && boardArray[1] == 0 && boardArray[2] == 1)
      {
        boardArray[1] = 2;
      }
      else if(boardArray[1] == 2 && boardArray[4] == 2 && boardArray[7] == 0)
      {
        boardArray[7] = 2;
      }
      else if(boardArray[0] == 0 && boardArray[3] == 1 && boardArray[6] == 0)
      {
        boardArray[0] = 2;
      }
      else
      {
        Find(boardArray, makeChoice);
      }
    }
  }
  
  private void Find (Integer[] boardArray, boolean makeChoice)
  {
    int indexDecreasing = 2;
    while (indexDecreasing >= 0 && !makeChoice)
    {
      for (int indexRow = 0; indexRow < 3 && !makeChoice; indexRow++)
      {
        if(boardArray[indexRow][indexDecreasing].equals("+"))
        {
          boardArray[indexRow][indexDecreasing] = "C";
          makeChoice = true;
        }
        else
        {
          --indexDecreasing;
        }
      }
    }
    for (int Index = 2; Index >=0 && !makeChoice; Index--)
    {
      if(boardArray[0][0].equals("+") && boardArray[1][0].equals("H") && boardArray[2][0].equals("H"))
      {
        boardArray[0][0] = "C";
        makeChoice = true;
      }
      else if (boardArray[Index][Index].equals("+"))
      {
        boardArray[Index][Index] = "C";
        makeChoice = true;
      }
    }
    int loop = 0;
    while (loop < 9 && !makeChoice())
    {
      if (boardArray[loop] == 0)
      {
        boardArray[loop] = 2;
        makeChoice() = true;
      }
      loop += 3;
    }
    
    for (int column = 0; column < 3 && !makeChoice; column++)
    {
      if (boardArray[column] == 0)
      {
        boardArray[column] = 2;
        makeChoice = true;
      }
    }
    
    for(int ParrelRow = 0; ParrelRow < 3 && !makeChoice; ParrelRow++)
    {
      for (int column = 0; column < 3 && !makeChoice; column++)
      {
        if(boardArray[column][ParrelRow].equals("+"))
        {
          boardArray[column][ParrelRow] = "C";
          makeChoice = true;
        }
      }
    }
    for(int PallelRow = 0; PallelRow < 3 && !makeChoice; PallelRow++)
    {
      if(boardArray[column][PallelRow].equals("+"))
      {
        boardArray[column][PallelRow] = "C";
        makeChoice = true;
      }
    }
  }
}
