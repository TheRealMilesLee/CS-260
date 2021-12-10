import java.util.*;
import java.io.*;


public class BackTrackingMaze
{
  private String[][] mazeArray;
  public void fileReading (String fileName)
  {
    try
    {
      File file = new File(fileName);
      
      Scanner fileReader = new Scanner(file);
      System.out.println("The file we read in is: " + fileName);
      int rowIndex = 0;
      int columnIndex = 0;
      while (fileReader.hasNextLine())
      {
        mazeArray[rowIndex][columnIndex] = fileReader.nextLine();
     
        if (fileReader.next().equals("\0"))
        {
          rowIndex++;
        }
        else
        {
          columnIndex++;
        }
      }
      fileReader.close();
    } catch (Exception notFound)
    {
      System.err.println(" File not found");
    }
  }
  
  public void displayMaze()
  {
    try
    {
      for (String[] strings : mazeArray)
      {
        for (int column = 0; column < mazeArray.length; column++)
        {
          if (strings[column].equals("\n"))
          {
            System.out.println();
          }
          else
          {
            System.out.print(strings[column]);
          }
        }
      }
    } catch (Exception n)
    {
      System.err.println("The array is empty!");
    }
  }
  
  public static void main(String[] args)
  {
    BackTrackingMaze mazeObject = new BackTrackingMaze();
    mazeObject.fileReading("1.txt");
    System.out.println("This is the current maze: ");
    mazeObject.displayMaze();
  }
  
}
