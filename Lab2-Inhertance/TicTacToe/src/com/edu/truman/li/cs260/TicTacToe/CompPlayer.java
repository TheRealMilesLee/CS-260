package com.edu.truman.li.cs260.TicTacToe;

/**
 * The type Computer player.
 */
public class CompPlayer extends Player
{
  /**
   * Computer change board.
   *
   * @param boardArray the board array
   */
  public void ComputerChangeBoard (String[][] boardArray)
  {
    boolean makeChoice = false;
    // If the center is empty, place computer chess on the center
    if (boardArray[1][1].equals("+"))
    {
      boardArray[1][1] = "C";
    }
    else if (boardArray[1][1].equals("H"))
    {
      if (boardArray[0][0].equals("H") && boardArray[2][2].equals("+"))
      {
        boardArray[2][2] = "C";
      }
      else if(boardArray[0][1].equals("H") && boardArray[2][1].equals("+"))
      {
        boardArray[2][1] = "C";
      }
      else if(boardArray[1][0].equals("H") && boardArray[1][2].equals("+"))
      {
        boardArray[1][2] = "C";
      }
      else if(boardArray[1][0].equals("+") && boardArray[1][2].equals("H"))
      {
        boardArray[1][0] = "C";
      }
      else if(boardArray[2][1].equals("H") && boardArray[0][1].equals("+"))
      {
        boardArray[0][1] = "C";
      }
      else if(boardArray[2][2].equals("H") && boardArray[0][0].equals("+"))
      {
        boardArray[0][0] = "C";
      }
      else if(boardArray[2][0].equals("H") && boardArray[2][1].equals("+") && boardArray[2][2].equals("H"))
      {
        boardArray[2][1] = "C";
      }
      else if(boardArray[0][0].equals("C") && boardArray[0][1].equals("+") && boardArray[0][2].equals("C"))
      {
        boardArray[0][1] = "C";
      }
      else
      {
        // Right diagonal find C
        Find(boardArray, makeChoice);
      }
    }
    else
    {
      if(boardArray[2][0].equals("H") && boardArray[2][1].equals("+") && boardArray[2][2].equals("H"))
      {
        boardArray[2][1] = "C";
      }
      else if(boardArray[0][0].equals("H") && boardArray[1][0].equals("+") && boardArray[2][0].equals("H") && (boardArray[2][1].equals("+") || boardArray[2][2].equals("H")))
      {
        boardArray[1][0] = "C";
      }
      else if(boardArray[0][2].equals("H") && boardArray[1][2].equals("+") && boardArray[2][2].equals("H") && boardArray[2][1].equals("+"))
      {
        boardArray[1][2] = "C";
      }
      else if(boardArray[0][2].equals("H") && boardArray[0][1].equals("H") && boardArray[0][0].equals("+"))
      {
        boardArray[0][0] = "C";
      }
      else if(boardArray[2][1].equals("C") && boardArray[1][1].equals("C") && boardArray[0][1].equals("+"))
      {
        boardArray[0][1] = "C";
      }
      else if(boardArray[0][0].equals("H") && boardArray[0][1].equals("+") && boardArray[0][2].equals("H"))
      {
        boardArray[0][1] = "C";
      }
      else if(boardArray[0][1].equals("C") && boardArray[1][1].equals("C") && boardArray[2][1].equals("+"))
      {
        boardArray[2][1] = "C";
      }
      else if(boardArray[0][0].equals("+") && boardArray[1][0].equals("H") && boardArray[2][0].equals("H"))
      {
        boardArray[0][0] = "C";
      }
      else
      {
        // Right diagonal find C
        Find(boardArray, makeChoice);
      }
    }
  }

  private void Find (String[][] boardArray, boolean makeChoice)
  {
    int indexDecreasing = 2;
    while (indexDecreasing >=0 && !makeChoice)
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

    for(int row = 0; row < 3 && !makeChoice; row++)
    {
      if(boardArray[row][2].equals("+"))
      {
        boardArray[row][2] = "C";
        makeChoice = true;
      }
    }
    for(int row = 0; row < 3 && !makeChoice; row++)
    {
      for (int column = 0; column < 3 && !makeChoice; column++)
      {
        if (boardArray[row][column].equals("+"))
        {
          boardArray[row][column] = "C";
          makeChoice = true;
        }
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
      for (int column = 2; column >=0 && !makeChoice; column--)
      {
        if(boardArray[column][PallelRow].equals("+"))
        {
          boardArray[column][PallelRow] = "C";
          makeChoice = true;
        }
      }
    }
  }
}
