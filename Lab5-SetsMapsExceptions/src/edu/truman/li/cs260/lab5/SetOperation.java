package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;

public class SetOperation
{
  private final Set<Student> evenSet = new HashSet<>();
  private final Set<Student> oddSet = new HashSet<>();
  public SetOperation()
  {
    divideFiles();
    fillSets();
    compareSets();
  }
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
        Student studentOddObject = new Student (readOdd.nextInt(), readOdd.nextLine());
        evenSet.add(studentEvenObject);
        oddSet.add(studentOddObject);
      }
    } catch (FileNotFoundException FileException)
    {
      System.out.println("File does not exists");
    }
  }
  public void divideFiles ()
  {
    File readStudentFiles = new File("students.txt");
    File oddFiles = new File ("oddlines.txt");
    File evenFiles = new File ("evenlines.txt");
    try
    {
      PrintWriter outputWriter = new PrintWriter(oddFiles);
      PrintWriter eventWriter = new PrintWriter(evenFiles);
      Scanner input = new Scanner(readStudentFiles);
      int lineCount = 0;
      while (input.hasNext())
      {
        if (lineCount % 2 == 0)
        {
          int student_id = input.nextInt();
          System.out.println(student_id);
          String student_name = input.next();
          System.out.println(student_name);
          eventWriter.println(student_id);
        }
        else
        {
          outputWriter.println(input.nextInt() + " " + input.nextLine());
        }
        lineCount++;
      }
    } catch (FileNotFoundException FileException)
    {
      System.out.println("File does not exists");
    }
  }
}
