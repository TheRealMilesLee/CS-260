package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;

public class Dictionary
{
  public void dictionary ()
  {
    // Read the dictionary and the document
    Map<Integer, String> dictionaryWords = makeDictionary("dictionary.txt");

  }
  
  public Map<Integer, String> makeDictionary (String filename)
  {
    Map<Integer, String> dictTemp = new HashMap<>();
    try
    {
      File readFile = new File(filename);
      Scanner inputFile = new Scanner(readFile);
      // Use any characters other than a-z or A-Z as delimiters
      inputFile.useDelimiter("[^a-zA-Z]+");
      int key = 0;
      while (inputFile.hasNext())
      {
        dictTemp.put(key, inputFile.next().toLowerCase());
        key++;
      }
      inputFile.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("file not exist!");
    }
    return dictTemp;
   }
}
