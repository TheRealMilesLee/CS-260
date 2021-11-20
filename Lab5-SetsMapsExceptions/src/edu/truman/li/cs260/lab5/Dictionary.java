package edu.truman.li.cs260.lab5;
import java.io.*;
import java.util.*;

public class Dictionary
{
  public void dictionary ()
  {
    // Read the dictionary and the document
    Map<Integer, String> dictionaryWords = makeDictionary("dictionary.txt");
    Map<String, String> wordsCoordinates = makeWords("words.txt");
    System.out.println(wordsCoordinates);
    System.out.println(dictionaryWords);
  }
  
  public Map<String, String> makeWords (String name)
  {
    Map<String, String> wordsTemp = new HashMap<>();
    try
    {
      File infile = new File(name);
      Scanner inputFile = new Scanner(infile);
      // Use any characters other than a-z or A-Z as delimiters
      inputFile.useDelimiter("[^a-zA-Z \n]+");
      int coordinatesColumn = 0;
      int coordinatesRow = 0;
      while (inputFile.hasNext())
      {
        wordsTemp.put((inputFile.next().toLowerCase()), coordinatesColumn + ""+coordinatesRow);
      }
      inputFile.close();
    }
    catch (FileNotFoundException ex)
    {
      System.out.println("file not exist!");
    }
    return wordsTemp;
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
