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
  
  /**
  public void ComputerInitialMove()
  {
    String PositionFromComputer = computerPlayerObject.generateComputerMove();
    int ComputerRow = Integer.parseInt(PositionFromComputer.substring(0,1));
    int ComputerColumn = Integer.parseInt(PositionFromComputer.substring(2,3));
    boardArray[ComputerRow][ComputerColumn] = "C";
  }
   */
  
  public void ComputerChangeBoard()
  {
    for(int row = 0; row < boardArray.length; row++)
    {
      for(int column = 0; column < boardArray.length; column++)
      {
        if(boardArray[row][column].equals("H"))
        {
          if(row + 1 <= 2)
          {
            if(boardArray[row + 1][column].equals("+"))
            {
              boardArray[row + 1][column] = "C";
            }
          }
          else if(column + 1 <= 2)
          {
            if(boardArray[row][column + 1].equals("+"))
            {
              boardArray[row][column + 1] = "C";
            }
          }
          else
          {
            if (boardArray[row - 1][column - 1].equals("+"))
            {
              boardArray[row - 1][column - 1] = "C";
            }
          }
        }
      }
    }
  }
  
  public String JudgeWinner()
  {
    String Winner = " ";
    if(boardArray[0][0].equals("H") && boardArray[0][1].equals("H") && boardArray[0][2].equals("H"))
    {
      System.out.println("The human is the winner!");
      Winner = "Human";
    }
    else if(boardArray[1][0].equals("H") && boardArray[1][1].equals("H") && boardArray[1][2].equals("H"))
    {
      System.out.println("The human is the winner!");
      Winner = "Human";
    }
    else if(boardArray[2][0].equals("H") && boardArray[2][1].equals("H") && boardArray[2][2].equals("H"))
    {
      System.out.println("The human is the winner!");
      Winner = "Human";
    }
    else if(boardArray[0][0].equals("H") && boardArray[1][1].equals("H") && boardArray[2][2].equals("H"))
    {
      System.out.println("The human is the winner!");
      Winner = "Human";
    }
    else if(boardArray[0][2].equals("H") && boardArray[1][1].equals("H") && boardArray[2][0].equals("H"))
    {
      System.out.println("The human is the winner!");
      Winner = "Human";
    }
    else if(boardArray[0][0].equals("H") && boardArray[1][0].equals("H") && boardArray[2][0].equals("H"))
    {
      System.out.println("The human is the winner!");
      Winner = "Human";
    }
    else if(boardArray[0][1].equals("H") && boardArray[1][1].equals("H") && boardArray[2][1].equals("H"))
    {
      System.out.println("The human is the winner!");
      Winner = "Human";
    }
    else if(boardArray[0][2].equals("H") && boardArray[1][2].equals("H") && boardArray[2][2].equals("H"))
    {
      System.out.println("The human is the winner!");
      Winner = "Human";
    }
    // Situation When Computer Win
    if(boardArray[0][0].equals("C") && boardArray[0][1].equals("C") && boardArray[0][2].equals("C"))
    {
      System.out.println("The human is the winner!");
      Winner = "Computer";
    }
    else if(boardArray[1][0].equals("C") && boardArray[1][1].equals("C") && boardArray[1][2].equals("C"))
    {
      System.out.println("The human is the winner!");
      Winner = "Computer";
    }
    else if(boardArray[2][0].equals("C") && boardArray[2][1].equals("C") && boardArray[2][2].equals("C"))
    {
      System.out.println("The human is the winner!");
      Winner = "Computer";
    }
    else if(boardArray[0][0].equals("C") && boardArray[1][1].equals("C") && boardArray[2][2].equals("C"))
    {
      System.out.println("The human is the winner!");
      Winner = "Computer";
    }
    else if(boardArray[0][2].equals("C") && boardArray[1][1].equals("C") && boardArray[2][0].equals("C"))
    {
      System.out.println("The human is the winner!");
      Winner = "Computer";
    }
    else if(boardArray[0][0].equals("C") && boardArray[1][0].equals("C") && boardArray[2][0].equals("C"))
    {
      System.out.println("The human is the winner!");
      Winner = "Computer";
    }
    else if(boardArray[0][1].equals("C") && boardArray[1][1].equals("C") && boardArray[2][1].equals("C"))
    {
      System.out.println("The human is the winner!");
      Winner = "Computer";
    }
    else if(boardArray[0][2].equals("C") && boardArray[1][2].equals("C") && boardArray[2][2].equals("C"))
    {
      System.out.println("The human is the winner!");
      Winner = "Computer";
    }
    else
    {
      System.out.println ("There is no winner, Tie");
      Winner = "Tie";
    }
    return Winner;
  }
}
