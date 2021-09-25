package com.edu.truman.li.cs260;

public class Board
{
  protected String[][] boardArray;
  CompPlayer computerPlayerObject = new CompPlayer();
  HumanPlayer humanPlayerObject = new HumanPlayer();
  public Board()
  {
    boardArray = new String[3][3];
    for(int row = 0; row < boardArray.length; row++)
    {
      for (int col = 0; col < boardArray.length; col++)
      {
        boardArray[row][col] = "+";
      }
    }
    DisplayBoard();
  }
  
  public void Direction()
  {
    System.out.println("The + indicates that these positions are empty and can be selected by the player. ");
    System.out.println("H stands for the human player move, and C stands for the computer player move.");
  }
  
  public void HumanChangeBoard()
  {
    humanPlayerObject.LetUserInput();
    String PositionFromUser = humanPlayerObject.returnRowAndColumn();
    int row = Integer.parseInt(PositionFromUser.substring(0, 1));
    int column = Integer.parseInt(PositionFromUser.substring(2, 3));
    boardArray[row][column] = "H";
  }
  public void DisplayBoard()
  {
    System.out.println("This is the current chess board");
    System.out.println();
    for (String[] strings : boardArray)
    {
      System.out.println(" -------------");
      for (int col = 0; col < boardArray.length; col++)
      {
        System.out.printf("%s"," | "+ strings[col]);
      }
      System.out.printf("%s", " |");
      System.out.println();
    }
    System.out.println(" -------------");
  }
}
