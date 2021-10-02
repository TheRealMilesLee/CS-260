package com.edu.truman.li.cs260;
public class Board
{
  protected String[][] boardArray;
  HumanPlayer humanPlayerObject = new HumanPlayer();
  CompPlayer ComputerObject = new CompPlayer();
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
  }
  public void clearBoard()
  {
    for(int row = 0; row < boardArray.length; row++)
    {
      for (int col = 0; col < boardArray.length; col++)
      {
        boardArray[row][col] = "+";
      }
    }
  }
  public void Direction()
  {
    System.out.println("The + indicates that these positions are empty and can be selected.");
    System.out.println("H stands for the human player move, C stands for the computer player move.");
    System.out.println("If you want to stop playing and exit, just type q to quit the game");
    System.out.println();
  }
  public void DisplayBoard()
  {
    System.out.println("This is the chess board");
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

  public void HumanChangeBoard()
  {
    humanPlayerObject.LetUserInput(boardArray);
  }
  
  public void ComputerSide()
  {
    ComputerObject.ComputerChangeBoard(boardArray);
  }
  public boolean boardIsFull()
  {
    boolean initialState = true;
    for (String[] strings : boardArray)
    {
      for (int col = 0; col < boardArray.length; col++)
      {
        if (strings[col].equals("+"))
        {
          initialState = false;
        }
      }
    }
    return initialState;
  }
  public String JudgeWinner()
  {
    String Winner = " ";
    String DiagonalLeftConcatenate = boardArray[0][0] + boardArray[1][1] + boardArray[2][2];
    String DiagonalRightConcatenate = boardArray[0][2] + boardArray[1][1] + boardArray[2][0];
    String RowOne = boardArray[0][0] + boardArray[0][1] + boardArray[0][2];
    String RowTwo = boardArray[1][0] + boardArray[1][1] + boardArray[1][2];
    String RowThree = boardArray[2][0] + boardArray[2][1] + boardArray[2][2];
    String ColumnOne = boardArray[0][0] + boardArray[1][0] + boardArray[2][0];
    String ColumnTwo = boardArray[0][1] + boardArray[1][1] + boardArray[2][1];
    String ColumnThree = boardArray[0][2] + boardArray[1][2] + boardArray[2][2];
    if(DiagonalLeftConcatenate.equals("CCC") || DiagonalRightConcatenate.equals("CCC"))
    {
      Winner = "Computer";
    }
    else if(DiagonalLeftConcatenate.equals("HHH") || DiagonalRightConcatenate.equals("HHH"))
    {
      Winner = "Human";
    }
    else if(RowOne.equals("CCC") || RowTwo.equals("CCC") || RowThree.equals("CCC"))
    {
      Winner = "Computer";
    }
    else if(RowOne.equals("HHH") || RowTwo.equals("HHH") || RowThree.equals("HHH"))
    {
      Winner = "Human";
    }
    else if(ColumnOne.equals("CCC") || ColumnTwo.equals("CCC") || ColumnThree.equals("CCC"))
    {
      Winner = "Computer";
    }
    else if(ColumnOne.equals("HHH") || ColumnTwo.equals("HHH") || ColumnThree.equals("HHH"))
    {
      Winner = "Human";
    }
    else
    {
      Winner = "Tie";
    }
    return Winner;
  }
}
