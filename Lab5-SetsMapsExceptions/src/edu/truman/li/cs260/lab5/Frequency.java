package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;

public class Frequency
{
  private final Map<String, Integer> wordCount = new HashMap<>();
  public void frequency ()
  {
    String[] words = fileReading("words.txt").split(" ");
    words = removePunctuation(words);
    for (String word : words)
    {
      wordCount.merge(word, 1, Integer::sum);
    }
    Set<String> keySet = wordCount.keySet();
    for (String keyValue : keySet)
    {
      Integer value = wordCount.get(keyValue);
      System.out.println(keyValue + " " + value);
    }
  }
  public String fileReading (String filename)
  {
    String linesOfWords = null;
    try
    {
      File file = new File(filename);
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
    return linesOfWords;
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
