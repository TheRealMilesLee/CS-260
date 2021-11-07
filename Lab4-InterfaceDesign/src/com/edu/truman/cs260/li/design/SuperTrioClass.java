package com.edu.truman.cs260.li.design;
import java.util.*;
/**
 * ToList() should return a Vector<String> object.
 */
public class SuperTrioClass implements Trio
{
  String valueA;
  String valueB;
  String valueC;
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
  public Vector<String> toList(String valueA, String valueB, String valueC)
  {
    Vector<String> myList = new Vector<>();
    myList.add(valueA);
    myList.add(valueB);
    myList.add(valueC);
    return myList;
  }
}
