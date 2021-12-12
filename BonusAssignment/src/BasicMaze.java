import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * This class is to show backtracking maze using stack
 */
public class BasicMaze
{
  private final Stack<String> pathStack = new Stack<>();
  private String[][] mazeArray;
  private int column = 0;
  private int row = 0;
  
  /**
   * The entry point of application.
   * @param args the input arguments
   */
  public static void main (String[] args)
  {
    BasicMaze mazeObject = new BasicMaze();
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
    pathStack.push(mazeArray[currentRow - 1][currentColumn]);  //Up
    pathStack.push(mazeArray[currentRow - 1][currentColumn + 1]);  //right
    pathStack.push(mazeArray[currentRow + 1][currentColumn]); //down
    currentRow += 1;
    pathStack.push(mazeArray[currentRow][currentColumn + 1]);  //right
    currentColumn += 1;
    pathStack.push(mazeArray[currentRow][currentColumn + 1]);  //right
    currentColumn += 1;
    pathStack.push(mazeArray[currentRow][currentColumn + 1]);  //right
    currentColumn += 1;
    pathStack.push(mazeArray[currentRow][currentColumn + 1]);  //right
    currentColumn += 1;
    pathStack.push(mazeArray[currentRow][currentColumn + 1]);  //right
    currentColumn += 1;
    currentRow -= 2;
    pathStack.push(mazeArray[currentRow][currentColumn]);  //Up
    currentColumn -= 1;
    pathStack.push(mazeArray[currentRow][currentColumn - 1]); //left
    currentColumn += 1;
    currentRow += 2;
    pathStack.push(mazeArray[currentRow + 1][currentColumn]); //down
    currentRow += 1;
    pathStack.push(mazeArray[currentRow + 1][currentColumn]); //down
    currentRow += 1;
    pathStack.push(mazeArray[currentRow][currentColumn - 1]); //left
    currentColumn -= 1;
    pathStack.push(mazeArray[currentRow + 1][currentColumn]); //down
    currentRow += 1;
    pathStack.push(mazeArray[currentRow + 1][currentColumn]); //down
  }
  
  /**
   * Print path.
   */
  public void printPath ()
  {
    for (String path : pathStack)
    {
      System.out.print(path);
    }
  }
}
