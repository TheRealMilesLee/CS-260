package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;


/**
 * The type Set operation.
 */
public class SetOperation
{
  private final Set<Student> evenSet = new HashSet<>();
  private final Set<Student> oddSet = new HashSet<>();
  
  /**
   * Main program running using constructor to call each functions
   */
  public SetOperation()
  {
    divideFiles();
    fillSets();
    compareSets();
  }
  
  /**
   * Compare sets.
   */
  public void compareSets()
  {
    for (Student EvenSetAccess : evenSet)
    {
      for (Student OddSetAccess : oddSet)
      {
        if ((EvenSetAccess.get_id() == OddSetAccess.get_id()) && (EvenSetAccess.get_name().equals(OddSetAccess.get_name())))
        {
          System.out.println(OddSetAccess.get_id() + " " + OddSetAccess.get_name());
        }
      }
    }
  }
  
  /**
   * Fill sets.
   */
  public void fillSets()
  {
    File readOddLines = new File("oddlines.txt");
    File readEvenLines = new File ("evenlines.txt");
    try
    {
      Scanner readEven = new Scanner(readEvenLines);
      Scanner readOdd = new Scanner (readOddLines);
      while (readEven.hasNext())
      {
        Student studentEvenObject = new Student(readEven.nextInt(), readEven.nextLine());
        Student studentOddObject = new Student(readOdd.nextInt(), readOdd.nextLine());
        evenSet.add(studentEvenObject);
        oddSet.add(studentOddObject);
      }
      readEven.close();
      readOdd.close();
    } catch (FileNotFoundException fileException)
    {
      System.out.println("File does not exists");
    }
  }
  
  /**
   * Divide files.
   */
  public void divideFiles ()
  {
    File readStudentFiles = new File("students.txt");
    
    try
    {
      Scanner input = new Scanner(readStudentFiles);
      PrintWriter oddWriter = new PrintWriter("oddlines.txt");
      PrintWriter evenWriter = new PrintWriter("evenlines.txt");
      int lineCount = 0;
      while (input.hasNext())
      {
        int studentID = input.nextInt();
        String studentName = input.next();
        if (lineCount % 2 == 0)
        {
          evenWriter.println(studentID + " " + studentName);
        }
        else
        {
          oddWriter.println(studentID + " " + studentName);
        }
        lineCount++;
      }
      input.close();
      oddWriter.close();
      evenWriter.close();
    } catch (FileNotFoundException nothingInFile)
    {
      System.out.println("File does not exists");
    }
  }
}
