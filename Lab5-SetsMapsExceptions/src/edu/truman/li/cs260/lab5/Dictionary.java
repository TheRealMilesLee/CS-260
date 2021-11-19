package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;

public class Dictionary
{
  public void Dic()
  {
    String dictionaryOfText = " ";
    try
    {
      File file = new File("words.txt");
      Scanner infile = new Scanner(file);
      while (infile.hasNextLine())
      {
        dictionaryOfText = infile.nextLine().toLowerCase();
      }
      infile.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Files does not exist.");
    }
    System.out.println(dictionaryOfText);
  }
}
