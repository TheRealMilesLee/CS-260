package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;

/**
 * This program shows the word frequency
 */
public class Frequency
{
  
  /**
   * Use constructor as the main program running
   */
  public Frequency ()
  {
    String[] words = getString("words.txt").split(" ");
    removePunctuation(words);
    Map<String, Integer> wordCount = new HashMap<>();
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
   * @param filename is the name of the file to get
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
      fileException.printStackTrace();
    }
    return stringFile;
  }
  
  /**
   * Remove punctuation.
   * @param lines is the lines to be removed the punctuation.
   */
  public static void removePunctuation (String[] lines)
  {
    for (int loop = 0; loop < lines.length; loop++)
    {
      lines[loop] = lines[loop].replaceAll("\\p{Punct}", "");
    }
  }
  
}
