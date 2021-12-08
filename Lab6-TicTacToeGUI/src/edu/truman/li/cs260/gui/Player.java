package edu.truman.li.cs260.gui;

public class Player
{
  private int row;
  private int column;
  public int getRow ()
  {
    return row;
  }
  public void setRow (int row)
  {
    this.row = row;
  }
  public int getColumn ()
  {
    return column;
  }
  public void setColumn (int column)
  {
    this.column = column;
  }
  
  /**
   * Judge winner string.
   * @return the string used to output the winner
   */
  public String JudgeWinner(Integer[] boardArray)
  {
    String Winner = "";
    if ((boardArray[0] + boardArray[1] + boardArray[2] == 3) ||
      (boardArray[3] + boardArray[4] + boardArray[5] == 3) ||
      (boardArray[6] + boardArray[7] + boardArray[8] == 3) ||
      (boardArray[0] + boardArray[4] + boardArray[8] == 3) ||
      (boardArray[2] + boardArray[4] + boardArray[5] == 3) ||
      (boardArray[0] + boardArray[3] + boardArray[6] == 3) ||
      (boardArray[1] + boardArray[4] + boardArray[7] == 3) ||
      (boardArray[2] + boardArray[5] + boardArray[8] == 3))
    {
      Winner = "Human";
    }
    else if ((boardArray[0] + boardArray[1] + boardArray[2] == 8) ||
      (boardArray[3] + boardArray[4] + boardArray[5] == 8) ||
      (boardArray[6] + boardArray[7] + boardArray[8] == 8) ||
      (boardArray[0] + boardArray[4] + boardArray[8] == 8) ||
      (boardArray[2] + boardArray[4] + boardArray[5] == 8) ||
      (boardArray[0] + boardArray[3] + boardArray[6] == 8) ||
      (boardArray[1] + boardArray[4] + boardArray[7] == 8) ||
      (boardArray[2] + boardArray[5] + boardArray[8] == 8))
    {
      Winner = "Computer";
    }
    else
    {
      Winner = "Tie";
    }
    return Winner;
  }
}
