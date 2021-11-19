package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;


public class Frequency
{
  private String linesOfWords = " ";
  private Map<String, Integer> wordCount = new HashMap<>();

  public void fileReadIn()
  {
    try
    {
      File file = new File("words.txt");
      Scanner infile = new Scanner(file);
      while (infile.hasNextLine())
      {
        linesOfWords = infile.next().toLowerCase();
      }
      infile.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("An error occurred.");
    }
  }

  public void countSameWords()
  {
    int key = 0;
    String[] words = linesOfWords.split("\\s");
    for(int looptimes = 1; looptimes < words.length; looptimes++)
    {
      key++;
      wordCount.put(words[looptimes], key);
    }
    System.out.println(wordCount);
  }

}
