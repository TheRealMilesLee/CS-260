package com.edu.truman.cs260.li.interfaceDesign;

import java.util.ArrayList;

public class IntegerTrio
{
  private int a, b, c;
  
  public IntegerTrio(int x, int y, int z)
  {
    a = x;
    b = y;
    c = z;
  }
  
  public ArrayList<Integer> toList()
  {
    ArrayList<Integer> newList = new ArrayList<Integer>();
    newList.add(a);
    newList.add(b);
    newList.add(c);
    return newList;
  }
  
  public Integer max()
  {
    if (a >= b && a >= c)
    {
      return a;
    }
    else if (b >= a && b >= c)
    {
      return b;
    }
    else
    {
      return c;
    }
  }
}
