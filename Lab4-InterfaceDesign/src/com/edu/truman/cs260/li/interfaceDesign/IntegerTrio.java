package com.edu.truman.cs260.li.interfaceDesign;

import java.util.ArrayList;

/** A class to represent three integers. */
public class IntegerTrio
{
  private int a, b, c;
  
  /**
   * Create and initialize a new object. @param x the first value
   * 
   * @param y the second value @param z the third value
   */
  public IntegerTrio(int x, int y, int z)
  {
    a = x;
    b = y;
    c = z;
  }
  
  /**
   * Create a list out of the trio's contents. @return the list
   */
  public ArrayList<Integer> toList()
  {
    ArrayList<Integer> newList = new ArrayList<Integer>();
    newList.add(a);
    newList.add(b);
    newList.add(c);
    return newList;
  }
  
  /**
   * Find and return the maximum of the three integers and return it as an
   * object.
   * 
   * @return the maximum as an object
   */
  public Integer max()
  {
    if (a >= b && a >= c)
      return a;
    if (b >= a && b >= c)
      return b;
    return c;
  }
}
