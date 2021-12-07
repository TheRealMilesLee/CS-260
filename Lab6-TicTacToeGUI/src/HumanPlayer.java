import java.util.Scanner;

public class HumanPlayer extends Player
{
  public void LetUserInput(String[][] boardArray)
  {
	  Scanner userInput = new Scanner(System.in);
    boolean validate = false;
    do
    {
      System.out.println("Now, make your move by typing the row and column separated with comma: ");
      
      String Location = userInput.nextLine();
      if(Location.isEmpty())
      {
        System.out.println("Please input a NUMBER!!!!!");
      }
      else if(Location.charAt(0) == ' ' || Location.charAt(2) == ' ')
      {
        System.out.println("USE NUMBERS! NOT SPACE!");
      }
      else
      {
        int row = Integer.parseInt(Location.substring(0, 1));
        int column = Integer.parseInt(Location.substring(2, 3));
        if (row > 2 && column <= 2)
        {
          System.out.println("The row is out of limit(0-2)!");
        }
        else if (row <= 2 && column > 2)
        {
          System.out.println("The Column is out of the limit(0-2)! ");
        }
        else if (row > 2 && column > 2)
        {
          System.out.println(" The Column and the row is out of the limit(0-2)! ");
        }
        else if (!boardArray[row][column].equals("+"))
        {
          System.out.println(" The place has already been occupied! ");
        }
        else
        {
          setRow(row);
          setColumn(column);
          validate = true;
        }
      }
      
    }while(!validate);
    boardArray[getRow()][getColumn()] = "H";
  }
}
