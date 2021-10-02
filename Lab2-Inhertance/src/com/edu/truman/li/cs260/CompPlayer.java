package com.edu.truman.li.cs260;

public class CompPlayer extends Player
{
  public void ComputerChangeBoard(String[][] boardArray)
  {
    boolean makeChoice = false;
    if(boardArray[1][1].equals("+"))
    {
      boardArray[1][1] = "C";
    }
    else
    {
      if (boardArray[0][0].equals("H") && boardArray[2][0].equals("H") && boardArray[1][0].equals("+"))
      {
        boardArray[1][0] = "C";
      }
      else if (boardArray[2][0].equals("+") && boardArray[2][1].equals("H") && boardArray[2][2].equals("H"))
      {
        boardArray[2][0] = "C";
      }
      else if (boardArray[2][0].equals("H") && boardArray[2][1].equals("H") && boardArray[2][2].equals("+"))
      {
        boardArray[2][2] = "C";
      }
      else if (boardArray[0][2].equals("H") && boardArray[2][2].equals("H") && boardArray[1][2].equals("+"))
      {
        boardArray[1][2] = "C";
      }
      else if(boardArray[0][1].equals("+") && boardArray[2][1].equals("H") && boardArray[1][1].equals("H"))
      {
        boardArray[0][1] = "C";
      }
      else if(boardArray[0][1].equals("H") && boardArray[2][1].equals("+") && boardArray[1][1].equals("H"))
      {
        boardArray[2][1] = "C";
      }
      else
      {
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
        for (int Index = 0; Index < boardArray.length && !makeChoice; Index++)
        {
          if (boardArray[Index][Index].equals("+"))
          {
            boardArray[Index][Index] = "C";
            makeChoice = true;
          }
        }
  
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
