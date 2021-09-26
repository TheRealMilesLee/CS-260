package com.edu.truman.li.cs260;
import java.util.Random;

public class CompPlayer extends Player
{
  public String generateComputerMove()
  {
    Random randomPosition = new Random();
    int randomRow = randomPosition.nextInt(2);
    int randomCol = randomPosition.nextInt(2);
    int RandomNonDuplicateRow = 0;
    int RandomNonDuplicateCol = 0;
    int computerChoiceRow;
    int computerChoiceCol;
    if (randomRow == getRow())
    {
      RandomNonDuplicateRow = randomPosition.nextInt(2);
    }
    else if (randomCol == getColumn())
    {
      RandomNonDuplicateCol = randomPosition.nextInt(2);
    }
    else
    {
      RandomNonDuplicateRow = randomRow;
      RandomNonDuplicateCol = randomCol;
    }
    
    computerChoiceRow = RandomNonDuplicateRow;
    computerChoiceCol = RandomNonDuplicateCol;
    return (computerChoiceRow + " " + computerChoiceCol);
  }
}
