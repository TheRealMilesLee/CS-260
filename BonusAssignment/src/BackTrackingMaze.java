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
    Scanner dummyReader = new Scanner(file);
    ArrayList<String> linesFromFile = new ArrayList<>();
    while (fileReaderLine.hasNextLine())
    {
      linesFromFile.add(fileReaderLine.nextLine());
      row++;
    }
    column = dummyReader.nextLine().length();
    mazeArray = new String[row][column];
    for (int rowIndex = 0; rowIndex < row; rowIndex++)
    {
      for (int columnIndex = 0; columnIndex < column; columnIndex++)
      {
        mazeArray[rowIndex][columnIndex] = String.valueOf(linesFromFile.get(rowIndex).charAt(columnIndex));
      }
    }

    fileReaderLine.close();
  }
  
  public void displayMaze()
  {
    for (int rowIndex = 0; rowIndex < row; rowIndex++)
    {
      for (int columnIndex = 0; columnIndex < column; columnIndex++)
      {
        System.out.print(mazeArray[rowIndex][columnIndex]);
      }
      System.out.println();
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
    mazeObject.displayMaze();
  }
  
}
