package com.edu.truman.cs260.li.design;

import java.util.ArrayList;

/** A class to represent three integers. */
public class IntegerTrio implements Trio<Integer>
{
  private int intValueA;
  private int intValueB;
  private int intValueC;

  /**
   * This function is to create and initialize a new object
   * @param firstValue  is the first int value
   * @param secondValue is the second int value
   * @param thirdValue  is the third int value
   */
  public IntegerTrio(int firstValue, int secondValue, int thirdValue)
  {
    intValueA = firstValue;
    intValueB = secondValue;
    intValueC = thirdValue;
  }

  /**
   * @Override Create a list out of the trio's contents.
   * @return the list
   */
  public ArrayList<Integer> toList()
  {
    ArrayList<Integer> newList = new ArrayList<>();
    newList.add(intValueA);
    newList.add(intValueB);
    newList.add(intValueC);
    return newList;
  }

  /**
   * @Override Find and return the maximum of the three integers and return it as an object.
   * @return the maximum as an object
   */
  public Integer max()
  {
    if (intValueA >= intValueB && intValueA >= intValueC)
    {
      return intValueA;
    }
    if (intValueB >= intValueA && intValueB >= intValueC)
    {
      return intValueB;
    }
    return intValueC;
  }
}
