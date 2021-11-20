package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;


public class Frequency
{
  private final Map<String, Integer> wordCount = new HashMap<>();
  public void frequency ()
  {
    String linesOfWords = null;
    try
    {
      File file = new File("words.txt");
      Scanner infile = new Scanner(file);
      while (infile.hasNextLine())
      {
        linesOfWords = infile.nextLine().toLowerCase();
      }
      infile.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("Files does not exist.");
    }
    int key = 0;
    
    try
    {
      String[] words = linesOfWords.split(" ");
      words = removePunctuation(words);
      for (String word : words)
      {
        for (String string : words)
        {
          if (word.equals(string))
          {
            key++;
          }
        }
        wordCount.put(word, key);
        key = 0;
      }
    } catch (NullPointerException n)
    {
      System.out.println("The string is null! ");
    }
    Set<String> keySet = wordCount.keySet();
    for (String keyValue : keySet)
    {
      Integer value = wordCount.get(keyValue);
      System.out.println(keyValue + " " + value);
    }
  }
  
  public String[] removePunctuation(String[] lines)
  {
    for (int loop = 0; loop < lines.length; loop++)
    {
      lines[loop] = lines[loop].replaceAll("\\p{Punct}", "");
    }
    return lines;
  }
}
