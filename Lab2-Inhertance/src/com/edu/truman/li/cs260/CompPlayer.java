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
      for (int IndexRight = 0; IndexRight < boardArray.length && !makeChoice; IndexRight++)
      {
        for (int IndexIncreasing = boardArray.length - 1; IndexIncreasing >= 0 && !makeChoice; IndexIncreasing--)
        {
          if(boardArray[1][1].equals("C") && !boardArray[1][2].equals("C"))
          {
            boardArray[1][2] = "C";
            makeChoice = true;
          }
          else if (boardArray[IndexRight][IndexIncreasing].equals("+"))
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
      for (int rowLoop = 0; rowLoop < boardArray.length && !makeChoice; rowLoop++)
      {
        for (int columnLoop = 0; columnLoop < boardArray.length && !makeChoice; columnLoop++)
        {
          if (boardArray[rowLoop][columnLoop].equals("+"))
          {
            boardArray[rowLoop][columnLoop] = "C";
            makeChoice = true;
          }
        }
      }

      
      for (int indexRow = 0; indexRow < boardArray.length && !makeChoice; indexRow++)
      {
        for (int columnLoop = 0; columnLoop < boardArray.length && !makeChoice; columnLoop++)
        {
          if (boardArray[columnLoop][indexRow].equals("+"))
          {
            boardArray[columnLoop][indexRow] = "C";
            makeChoice = true;
          }
        }
      }


    }
  }
}
