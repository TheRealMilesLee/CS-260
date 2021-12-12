import java.util.*;
import java.io.*;


public class BackTrackingMaze
{
  private final Stack<String> pathStack = new Stack<>();
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
  public void makeMove()
  {
    boolean done = false;
    // Find current position
    int currentRow = 0;
    int currentColumn = 0;
    for (int rowIndex = 0; rowIndex < row && !done; rowIndex++)
    {
      for (int columnIndex = 0; columnIndex < column && !done; columnIndex++)
      {
        if(mazeArray[rowIndex][columnIndex].equals("^"))
        {
          currentRow = rowIndex;
          currentColumn = columnIndex;
          done = true;
        }
      }
    }
    // Push current position on stack
    pathStack.push(mazeArray[currentRow][currentColumn]);
    // Find the exit place
    int exitRow = 0;
    int exitColumn = 0;
    for (int rowIndex = 0; rowIndex < row && !done; rowIndex += (row - 1))
    {
      for (int columnIndex = 0; columnIndex < column && !done; columnIndex++)
      {
        if(!mazeArray[rowIndex][columnIndex].equals("#"))
        {
          exitRow = rowIndex;
          exitColumn = columnIndex;
          done = true;
        }
      }
    }
  
    for (int rowIndex = 0; rowIndex < row && !done; rowIndex++)
    {
      for (int columnIndex = 0; columnIndex < column && !done; columnIndex += (column-1))
      {
        if(!mazeArray[rowIndex][columnIndex].equals("#"))
        {
          exitRow = rowIndex;
          exitColumn = columnIndex;
          done = true;
        }
      }
    }
  }
  
  public void findWayOut()
  {
    boolean done = false;
    
  
  }
  public void printPath()
  {
    for (String path : pathStack)
    {
      System.out.print(path);
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
    System.out.println("This is the path to find a way out: ");
    mazeObject.makeMove();
    mazeObject.printPath();
  }
  
}
