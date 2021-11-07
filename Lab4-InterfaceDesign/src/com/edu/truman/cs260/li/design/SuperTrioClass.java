package com.edu.truman.cs260.li.design;
import java.util.*;
/**
 * You will want to use the fact that both the ArrayList and the LinkedList implement the interface java.util.List
 * ToList() should return a Vector<String> object.
 */
public class SuperTrioClass implements Trio<String>
{
  private String valueA;
  private String valueB;
  private String valueC;
  public SuperTrioClass(String firstValue, String secondValue, String thirdValue)
  {
    valueA = firstValue;
    valueB = secondValue;
    valueC = thirdValue;
  }
  @Override
  public String max()
  {
    if (valueA.compareTo(valueB) > 0)
    {
      if(valueA.compareTo(valueC) > 0)
      {
        return valueA;
      }
    }
    else if (valueB.compareTo(valueC) > 0)
    {
      return valueB;
    }
    return valueC;
  }
  @Override
  public Vector<String> toList()
  {
    Vector<String> myList = new Vector<>();
    myList.add(valueA);
    myList.add(valueB);
    myList.add(valueC);
    return myList;
  }
}
