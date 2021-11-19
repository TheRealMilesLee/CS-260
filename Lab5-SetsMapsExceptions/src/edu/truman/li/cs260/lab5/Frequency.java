package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;


public class Frequency
{
  public void fileReadIn()
  {
    Map<String, Integer> WordCount = new HashMap<String, Integer>();
    try 
    {
      File file = new File("words.txt");
      Scanner infile = new Scanner(file);
      while (infile.hasNextLine()) 
      {
         
      }
      infile.close();
    } 
    catch (FileNotFoundException e) 
    {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
}
