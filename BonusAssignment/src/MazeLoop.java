import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class MazeLoop
{
  private final Stack<String> pathStack = new Stack<>();
  private String[][] mazeArray;
  private int column = 0;
  private int row = 0;
  
  /**
   * File reading.
   * @param fileName the file name
   * @exception FileNotFoundException the file not found exception
   */
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
  
  
  /**
   * Display maze.
   */
  public void displayMaze ()
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
  public void printPath ()
  {
    for (String path : pathStack)
    {
      System.out.print(path);
    }
  }
  
  
  /**
   * Make move.
   */
  public void makeMove ()
  {
    boolean done = false;
    // Find current position
    int currentRow = 0;
    int currentColumn = 0;
    for (int rowIndex = 0; rowIndex < row && !done; rowIndex++)
    {
      for (int columnIndex = 0; columnIndex < column && !done; columnIndex++)
      {
        if (mazeArray[rowIndex][columnIndex].equals("^"))
        {
          currentRow = rowIndex;
          currentColumn = columnIndex;
          done = true;
        }
      }
    }
    pathStack.push(mazeArray[currentRow][currentColumn]);
    // Starting current position, going up, right, down, left
    while (currentColumn < column - 1 && currentRow < row - 1)
    {
      if (!mazeArray[currentRow][currentColumn].equals("#"))
      {
        pathStack.push(mazeArray[currentRow][currentColumn]);
      }
      if (!mazeArray[currentRow - 1][currentColumn].equals("#"))
      {
        pathStack.push(mazeArray[currentRow - 1][currentColumn]);
      }
      if (!mazeArray[currentRow][currentColumn - 1].equals("#"))
      {
        pathStack.push(mazeArray[currentRow][currentColumn - 1]);
      }
      if (! mazeArray[currentRow - 1][currentColumn + 1].equals("#"))
      {
        pathStack.push(mazeArray[currentRow - 1][currentColumn + 1]);
      }
      if (! mazeArray[currentRow + 1][currentColumn - 1].equals("#"))
      {
        pathStack.push(mazeArray[currentRow + 1][currentColumn - 1]);
      }
      if (! mazeArray[currentRow][currentColumn + 1].equals("#"))
      {
        pathStack.push(mazeArray[currentRow][currentColumn + 1]);
      }
      if (! mazeArray[currentRow + 1][currentColumn].equals("#"))
      {
        pathStack.push(mazeArray[currentRow + 1][currentColumn]);
      }
      currentRow++;
      currentColumn++;
    }
  }
  /**
   * The entry point of application.
   * @param args the input arguments
   */
  public static void main (String[] args)
  {
    MazeLoop loopMaze = new MazeLoop();
    try
    {
      loopMaze.fileReading("maze.txt");
    } catch (FileNotFoundException fileException)
    {
      System.out.println("The file is not found");
    }
    System.out.println("This is the current maze: ");
    loopMaze.displayMaze();
    System.out.println("This is the path to find a way out: ");
    loopMaze.makeMove();
    loopMaze.printPath();
  }
}
