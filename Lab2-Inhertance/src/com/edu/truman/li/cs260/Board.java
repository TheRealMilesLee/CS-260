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
    humanPlayerObject.LetUserInput();
    String PositionFromUser = humanPlayerObject.returnRowAndColumn();
    int HumanRow = Integer.parseInt(PositionFromUser.substring(0, 1));
    int HumanColumn = Integer.parseInt(PositionFromUser.substring(2, 3));
    boardArray[HumanRow][HumanColumn] = "H";
  }

  public void ComputerInitialMove()
  {
    String PositionFromComputer = computerPlayerObject.generateComputerMove();
    int ComputerRow = Integer.parseInt(PositionFromComputer.substring(0,1));
    int ComputerColumn = Integer.parseInt(PositionFromComputer.substring(2,3));
    boardArray[ComputerRow][ComputerColumn] = "C";
  }

  public void ComputerChangeBoard()
  {
    String DiagonalLeftConcatenate = boardArray[0][0] + boardArray[1][1] + boardArray[2][2];
    String DiagonalRightConcatenate = boardArray[0][2] + boardArray[1][1] + boardArray[2][0];
    String RowOne = boardArray[0][0] + boardArray[0][1] + boardArray[0][2];
    String RowTwo = boardArray[1][0] + boardArray[1][1] + boardArray[1][2];
    String RowThree = boardArray[2][0] + boardArray[2][1] + boardArray[2][2];
    String ColumnOne = boardArray[0][0] + boardArray[1][0] + boardArray[2][0];
    String ColumnTwo = boardArray[0][1] + boardArray[1][1] + boardArray[2][1];
    String ColumnThree = boardArray[0][2] + boardArray[1][2] + boardArray[2][2];
    boolean HaveDecided = false;
    int count = 0;
    while(!HaveDecided)
    {
      if(RowOne.charAt(count) == '+')
      {
        boardArray[0][count] = "C";
        HaveDecided = true;
      }
      else
      {
        if(RowOne.equals("CHH") || RowOne.equals("HCH") || RowOne.equals("HHC"))
        {
          if(RowOne.equals("CHH"))
          {
            if(ColumnOne.charAt(count) == '+')
            {
              boardArray[count][0] = "C";
              HaveDecided = true;
            }
          }
          else if( RowOne.equals("HCH"))
          {
            if(ColumnTwo.charAt(count) == '+')
            {
              boardArray[count][1] = "C";
              HaveDecided = true;
            }
          }
          else
          {
            if(ColumnThree.charAt(count) == '+')
            {
              boardArray[count][2] = "C";
              HaveDecided = true;
            }
          }

        }
        else
        {
          count++;
        }
      }
    }

}
  public String JudgeWinner()
  {
    String Winner = " ";
    String DiagonalLeftConcatenate = boardArray[0][0] + boardArray[1][1] + boardArray[2][2];
    String DiagonalRightConcatenate = boardArray[0][2] + boardArray[1][1] + boardArray[2][0];
    if(DiagonalLeftConcatenate.equals("CCC") || DiagonalRightConcatenate.equals("CCC"))
    {
      Winner = "Computer";
    }
    if(DiagonalLeftConcatenate.equals("HHH") || DiagonalRightConcatenate.equals("HHH"))
    {
      Winner = "Human";
    }
    
    String RowOne = boardArray[0][0] + boardArray[0][1] + boardArray[0][2];
    String RowTwo = boardArray[1][0] + boardArray[1][1] + boardArray[1][2];
    String RowThree = boardArray[2][0] + boardArray[2][1] + boardArray[2][2];
    String ColumnOne = boardArray[0][0] + boardArray[1][0] + boardArray[2][0];
    String ColumnTwo = boardArray[0][1] + boardArray[1][1] + boardArray[2][1];
    String ColumnThree = boardArray[0][2] + boardArray[1][2] + boardArray[2][2];
  
    if(RowOne.equals("CCC") || RowTwo.equals("CCC") || RowThree.equals("CCC"))
    {
      Winner = "Computer";
    }
    if(RowOne.equals("HHH") || RowTwo.equals("HHH") || RowThree.equals("HHH"))
    {
      Winner = "Human";
    }
    if(ColumnOne.equals("CCC") || ColumnTwo.equals("CCC") || ColumnThree.equals("CCC"))
    {
      Winner = "Computer";
    }
    if(ColumnOne.equals("HHH") || ColumnTwo.equals("HHH") || ColumnThree.equals("HHH"))
    {
      Winner = "Human";
    }
    return Winner;
  }
}
