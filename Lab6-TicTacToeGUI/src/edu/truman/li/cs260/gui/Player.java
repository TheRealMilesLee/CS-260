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
    if ((boardArray[0] == 1 && boardArray[1] == 1 && boardArray[2] == 1) ||
      (boardArray[3] == 1 && boardArray[4] == 1 && boardArray[5] == 1) ||
      (boardArray[6] == 1 && boardArray[7] == 1 && boardArray[8] == 1) ||
      (boardArray[0] == 1 && boardArray[4] == 1 && boardArray[8] == 1) ||
      (boardArray[2] == 1 && boardArray[4] == 1 && boardArray[6] == 1) ||
      (boardArray[0] == 1 && boardArray[3] == 1 && boardArray[6] == 1) ||
      (boardArray[1] == 1 && boardArray[4] == 1 && boardArray[7] == 1) ||
      (boardArray[2] == 1 && boardArray[5] == 1 && boardArray[8] == 1))
    {
      Winner = "Human";
    }
    else if ((boardArray[0] == 2 && boardArray[1] == 2 && boardArray[2] == 2) ||
      (boardArray[3] == 2 && boardArray[4] == 2 && boardArray[5] == 2) ||
      (boardArray[6] == 2 && boardArray[7] == 2 && boardArray[8] == 2) ||
      (boardArray[0] == 2 && boardArray[4] == 2 && boardArray[8] == 2) ||
      (boardArray[2] == 2 && boardArray[4] == 2 && boardArray[6] == 2) ||
      (boardArray[0] == 2 && boardArray[3] == 2 && boardArray[6] == 2) ||
      (boardArray[1] == 2 && boardArray[4] == 2 && boardArray[7] == 2) ||
      (boardArray[2] == 2 && boardArray[5] == 2 && boardArray[8] == 2))
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
