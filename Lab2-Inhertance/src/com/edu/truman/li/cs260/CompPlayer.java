package com.edu.truman.li.cs260;

/**
 * The type Comp player.
 */
public class CompPlayer extends Player
{
  /**
   * Computer change board.
   *
   * @param boardArray the board array
   */
  public void ComputerChangeBoard(String[][] boardArray)
  {
    boolean makeChoice = false;
    // If the center is empty, place computer chess on the center
    if(boardArray[1][1].equals("+"))
    {
      boardArray[1][1] = "C";
    }
    else
    {
      // Situation HCH in column 0
      if (boardArray[0][0].equals("H") && boardArray[2][0].equals("H") && boardArray[1][0].equals("+"))
      {
        boardArray[1][0] = "C";
      }
<<<<<<< HEAD
<<<<<<< HEAD
      // Situation CHH in row 2
      else if (boardArray[2][0].equals("+") && boardArray[2][1].equals("H") && boardArray[2][2].equals("H"))
      {
        boardArray[2][0] = "C";
      }
      // Situation HHC in row 2
      else if (boardArray[2][0].equals("H") && boardArray[2][1].equals("H") && boardArray[2][2].equals("+"))
      {
        boardArray[2][2] = "C";
      }
      // Situation HCH in column 2
=======
>>>>>>> parent of 53e1608 (IT'S FUCKING DONE)
=======
>>>>>>> parent of 53e1608 (IT'S FUCKING DONE)
      else if (boardArray[0][2].equals("H") && boardArray[2][2].equals("H") && boardArray[1][2].equals("+"))
      {
        boardArray[1][2] = "C";
      }
      // Situation CHH in column 1
      else if(boardArray[0][1].equals("+") && boardArray[2][1].equals("H") && boardArray[1][1].equals("H"))
      {
        boardArray[0][1] = "C";
      }
      // Situation HHC in column 1
      else if(boardArray[0][1].equals("H") && boardArray[2][1].equals("+") && boardArray[1][1].equals("H"))
      {
        boardArray[2][1] = "C";
      }
      else
      {
        // Right diagonal find C
        for (int IndexRight = 0; IndexRight < boardArray.length && !makeChoice; IndexRight++)
        {
          for (int IndexIncreasing = boardArray.length - 1; IndexIncreasing >= 0 && !makeChoice; IndexIncreasing--)
          {
            if (boardArray[IndexRight][IndexIncreasing].equals("+"))
            {
              boardArray[IndexRight][IndexIncreasing] = "C";
              makeChoice = true;
            }
          }
        }
        //Left diagonal find C
        for (int Index = 0; Index < boardArray.length && !makeChoice; Index++)
        {
          if (boardArray[Index][Index].equals("+"))
          {
            boardArray[Index][Index] = "C";
            makeChoice = true;
          }
        }
        // Column find C
        for (int indexRow = 0; indexRow < boardArray.length - 1 && !makeChoice; indexRow++)
        {
          for (int columnLoop = 0; columnLoop < boardArray.length - 1 && !makeChoice; columnLoop++)
          {
            if (boardArray[columnLoop][indexRow].equals("+"))
            {
              boardArray[columnLoop][indexRow] = "C";
              makeChoice = true;
            }
          }
        }
        // Row Find C
        for (int rowLoop = 0; rowLoop < boardArray.length - 1 && !makeChoice; rowLoop++)
        {
          for (int columnLoop = 0; columnLoop < boardArray.length - 1 && !makeChoice; columnLoop++)
          {
            if (boardArray[rowLoop][columnLoop].equals("+"))
            {
              boardArray[rowLoop][columnLoop] = "C";
              makeChoice = true;
            }
          }
        }
      }
    }
  }
}
