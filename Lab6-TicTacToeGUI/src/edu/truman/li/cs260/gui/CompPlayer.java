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
  public int ComputerChangeBoard (Integer[] boardArray)
  {
    int index = 0;
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
      else if(boardArray[1] == 1 && boardArray[7] == 0)
      {
        boardArray[7] = 2;
        index = 7;
      }
      else if(boardArray[3] == 1 && boardArray[5] == 0)
      {
        boardArray[5] = 2;
        index = 5;
      }
      else if(boardArray[3] == 0 && boardArray[5] == 1)
      {
        boardArray[3] = 2;
        index = 3;
      }
      else if(boardArray[7] == 1 && boardArray[1] == 0)
      {
        boardArray[1] = 2;
        index = 1;
      }
      else if(boardArray[8] == 1 && boardArray[0] == 0)
      {
        boardArray[0] = 2;
      }
      else if(boardArray[6] == 1 && boardArray[7] == 0 && boardArray[8] == 1)
      {
        boardArray[7] = 2;
        index = 7;
      }
      else if(boardArray[0] == 2 && boardArray[1] == 0 && boardArray[2] == 2)
      {
        boardArray[1] = 2;
        index = 1;
      }
      else
      {
        index = Find(boardArray);
      }
    }
    else
    {
      if(boardArray[6] == 1 && boardArray[7] == 0 && boardArray[8] == 1)
      {
        boardArray[7] = 2;
        index = 7;
      }
      else if(boardArray[0] == 1 && boardArray[3] == 0 && boardArray[6] == 1 && (boardArray[7] == 0 || boardArray[8] == 1))
      {
        boardArray[3] = 2;
        index = 3;
      }
      else if(boardArray[2] == 1 && boardArray[5] == 0 && boardArray[8] == 1 && boardArray[7] == 0)
      {
        boardArray[5] = 2;
        index = 5;
      }
      else if(boardArray[2] == 1 && boardArray[1] == 1 && boardArray[0] == 0)
      {
        boardArray[0] = 2;
      }
      else if(boardArray[7] == 2 && boardArray[4] == 2 && boardArray[1] == 0)
      {
        boardArray[1] = 2;
        index = 1;
      }
      else if(boardArray[0] == 1 && boardArray[1] == 0 && boardArray[2] == 1)
      {
        boardArray[1] = 2;
        index = 1;
      }
      else if(boardArray[1] == 2 && boardArray[4] == 2 && boardArray[7] == 0)
      {
        boardArray[7] = 2;
        index = 7;
      }
      else if(boardArray[0] == 0 && boardArray[3] == 1 && boardArray[6] == 1)
      {
        boardArray[0] = 2;
      }
      else
      {
        index = Find(boardArray);
      }
    }
    return index;
  }
  
  private int Find (Integer[] boardArray)
  {

    //Right Diagonal
    for (int index = 2; index < 9 ; index += 2)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        return index;
      }
    }
    //left Diagonal
    for (int index = 0; index < 9; index += 4)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        return index;
      }
    }
    // column 3
    for (int index = 2; index < 9; index += 3)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        return index;
      }
    }
    // column 2
    for (int index = 1; index < 9; index += 3)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        return index;
      }
    }
    //column 1
    for (int index = 0; index < 9; index += 3)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        return index;
      }
    }
    return 0;
  }
}
