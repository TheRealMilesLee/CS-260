package com.edu.truman.cs260.li.design;

import java.util.*;

public class SuperTrioClass implements Trio<String>
{
  private String valueA;
  private String valueB;
  private String valueC;
  
  public SuperTrioClass(String firstValue, String secondValue,
      String thirdValue)
  {
    valueA = firstValue;
    valueB = secondValue;
    valueC = thirdValue;
  }
  
  public Vector<String> toList()
  {
    Vector<String> myList = new Vector<>();
    myList.add(valueA);
    myList.add(valueB);
    myList.add(valueC);
    return myList;
  }
  
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
