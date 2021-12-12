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
  
  public void GoingUp(int currentRow, int currentColumn)
  {
    if (!mazeArray[currentRow - 1][currentColumn].equals("#"))
    {
      currentRow -= 1;
      pathStack.push(mazeArray[currentRow][currentColumn]);
    }
  }
  
  public void GoingDown(int currentRow, int currentColumn)
  {
    if (!mazeArray[currentRow + 1][currentColumn].equals("#"))
    {
      currentRow += 1;
      pathStack.push(mazeArray[currentRow][currentColumn]);
    }
  }
  
  public void GoingRight(int currentRow, int currentColumn)
  {
    if (!mazeArray[currentRow][currentColumn + 1].equals("#"))
    {
      currentColumn += 1;
      pathStack.push(mazeArray[currentRow][currentColumn]);
    }
  }
  
  public void GoingLeft(int currentRow, int currentColumn)
  {
    if (!mazeArray[currentRow][currentColumn - 1].equals("#"))
    {
      pathStack.push(mazeArray[currentRow][currentColumn - 1]);
      currentColumn += 1;
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
    pathStack.push(mazeArray[currentRow][currentColumn]);
    // Starting current position, going up, right, down, left
    while (currentColumn < column - 1 && currentRow < row - 1)
    {
      //Going up
      
      //Going up right
      
      //Going down
      
      //Going right

      currentRow += 1;
      currentColumn += 1;
    }
  }
  
  public void findWayOut()
  {
    boolean done = false;
    // Find the exit place
    int exitRow = 0;
    int exitColumn = 0;
    for (int columnIndex = 0; columnIndex < column && !done; columnIndex++)
    {
      if (!mazeArray[0][columnIndex].equals("#"))
      {
        exitColumn = columnIndex;
        done = true;
      }
      else if (!mazeArray[row - 1][columnIndex].equals("#"))
      {
        exitRow = row - 1;
        exitColumn = columnIndex;
        done = true;
      }
    }
    for (int rowIndex = 0; rowIndex < row && !done; rowIndex++)
    {
      if (!mazeArray[rowIndex][0].equals("#"))
      {
        exitRow = rowIndex;
        done = true;
      }
      else if (!mazeArray[rowIndex][column - 1].equals("#"))
      {
        exitRow = rowIndex;
        exitColumn = column - 1;
        done = true;
      }
    }
  
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
