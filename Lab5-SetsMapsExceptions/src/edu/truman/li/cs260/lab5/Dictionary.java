package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;

public class Dictionary
{
  public void dictionary ()
  {
    Map<String, Integer> dictionaryWords = makeDictionary("dictionary.txt");
    File input = new File("words.txt");
    try
    {
      Scanner inputFile = new Scanner(input);
      int row = 1;
      do
      {
        int column = 1;
        String wordsFromFile = inputFile.nextLine();
        String Lowercase = wordsFromFile.toLowerCase();
        String[] originalString = cleanUpString(wordsFromFile);
        String[] cleanString = cleanUpString(Lowercase);
        for (int loop = 0; loop < cleanString.length; loop++)
        {
          if (!dictionaryWords.containsKey(cleanString[loop]))
          {
            System.out.println(originalString[loop] + " " + row + " " + column);
          }
          column++;
        }
        row++;
      }while (inputFile.hasNextLine());
    } catch (FileNotFoundException FileException)
    {
      System.out.println("The file is not found");
    }
  }
  public String[] cleanUpString (String dirtyString )
  {
    String[] getCleanUpWords = dirtyString.split(" ");
    removePunctuation(getCleanUpWords);
    return getCleanUpWords;
  }
  public Map<String, Integer> makeDictionary (String filename)
  {
    Map<String, Integer> dictTemp = new HashMap<>();
    try
    {
      File file = new File(filename);
      Scanner infile = new Scanner(file);
      int key = 0;
      while (infile.hasNext())
      {
        dictTemp.put(infile.next().toLowerCase(), key);
        key++;
      }
      infile.close();
    }
    catch (FileNotFoundException fileException)
    {
      System.out.println("Files does not exist.");
    }
    return dictTemp;
   }
  public static void removePunctuation (String[] lines)
  {
    for (int loop = 0; loop < lines.length; loop++)
    {
      lines[loop] = lines[loop].replaceAll("\\p{Punct}", "");
    }
  }
}
