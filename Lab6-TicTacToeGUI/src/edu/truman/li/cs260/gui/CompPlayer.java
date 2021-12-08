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
        // Right diagonal find C
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
        // Right diagonal find C
        Find(boardArray, makeChoice);
      }
    }
  }
  
  private void Find (Integer[] boardArray, boolean makeChoice)
  {

    //Right Diagonal
    for (int index = 2; index < 9 && !makeChoice; index += 2)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        makeChoice = true;
      }
    }
    //left Diagonal
    for (int index = 0; index < 9 && !makeChoice; index += 4)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        makeChoice = true;
      }
    }
    // column 3
    for (int index = 2; index < 9 && !makeChoice; index += 3)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        makeChoice = true;
      }
    }
    // column 2
    for (int index = 1; index < 9 && !makeChoice; index += 3)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        makeChoice = true;
      }
    }
    //column 1
    for (int index = 0; index < 9 && !makeChoice; index += 3)
    {
      if (boardArray[index] == 0)
      {
        boardArray[index] = 2;
        makeChoice = true;
      }
    }
  }
}
