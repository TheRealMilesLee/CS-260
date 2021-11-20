package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;

/**
 * The type Frequency.
 */
public class Frequency
{
  private final Map<String, Integer> wordCount = new HashMap<>();
  
  /**
   * Instantiates a new Frequency.
   */
  public Frequency ()
  {
    String[] words = getString("words.txt").split(" ");
    removePunctuation(words);
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
  
  /**
   * Gets string.
   *
   * @param filename the filename
   * @return the string
   */
  public static String getString (String filename)
  {
    String stringFile = "";
    try
    {
      File file = new File(filename);
      Scanner infile = new Scanner(file);
      while (infile.hasNextLine())
      {
        stringFile = infile.nextLine().toLowerCase();
      }
      infile.close();
    }
    catch (FileNotFoundException fileException)
    {
      System.out.println("Files does not exist.");
    }
    return stringFile;
  }
  
  /**
   * Remove punctuation.
   *
   * @param lines the lines
   */
  public static void removePunctuation (String[] lines)
  {
    for (int loop = 0; loop < lines.length; loop++)
    {
      lines[loop] = lines[loop].replaceAll("\\p{Punct}", "");
    }
  }
  
}
