import java.util.*;
import java.io.*;


public class BackTrackingMaze
{
  private String[][] mazeArray;
  private int column = 0;
  private int row = 0;
  public void fileReading (String fileName) throws FileNotFoundException
  {
    File file = new File(fileName);
    Scanner fileReaderLine = new Scanner(file);
    Scanner fileReaderColumn = new Scanner(file);
    ArrayList<String> linesFromFile = new ArrayList<>();
    while (fileReaderLine.hasNext())
    {
      linesFromFile.add(fileReaderLine.next());
      if(fileReaderLine.next().equals("\n"))
      {
        row++;
      }
      else
      {
        column++;
      }
    }
    mazeArray = new String[row][column];
    for (int index = 0; index < linesFromFile.size(); index++)
    {
      for (int loop = 0; loop < linesFromFile.size(); loop++)
      {
        mazeArray[index][loop] = linesFromFile.get(loop);
      }
    }
    fileReaderColumn.close();
  }
  
  public void displayMaze()
  {
    for (int row = 0; row < 8; row++)
    {
      for (int column = 0; column < mazeArray.length; column++)
      {
        if (mazeArray[row][column].equals(" "))
        {
          System.out.println();
        }
        else
        {
          System.out.print(mazeArray[row][column]);
        }
      }
    }
  }
  
  public static void main(String[] args)
  {
    BackTrackingMaze mazeObject = new BackTrackingMaze();
    try
    {
      mazeObject.fileReading("maze.txt");
    } catch (FileNotFoundException fileException)
    {
      System.out.println("The file is not found");
    }
    System.out.println("This is the current maze: ");
   // mazeObject.displayMaze();
  }
  
}
