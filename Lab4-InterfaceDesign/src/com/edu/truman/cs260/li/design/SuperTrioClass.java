package com.edu.truman.cs260.li.design;
import java.util.*;

public class SuperTrioClass implements Trio<String>
{
  private String valueA;
  private String valueB;
  private String valueC;

  /**
   * This is the constructor of the SuperTrioClass.
   * @param firstValue is the first string value
   * @param secondValue is the second string value
   * @param thirdValue is the third string value
   */
  public SuperTrioClass(String firstValue, String secondValue,
      String thirdValue)
  {
    valueA = firstValue;
    valueB = secondValue;
    valueC = thirdValue;
  }

  /**
   * @Override This function is to store everything into a list
   */
  public Vector<String> toList()
  {
    Vector<String> myList = new Vector<>();
    myList.add(valueA);
    myList.add(valueB);
    myList.add(valueC);
    return myList;
  }

  /**
   * @Override This function is to compare which one is bigger than the other.
   */
  public String max()
  {
    if (valueA.compareTo(valueB) >= 0)
    {
      if (valueA.compareTo(valueC) >= 0)
      {
        return valueA;
      }
    }
    else if (valueB.compareTo(valueC) >= 0)
    {
      return valueB;
    }
    return valueC;
  }
}
