package com.edu.truman.cs260.li.design;
import java.util.List;
/**
 * This class should contain three Strings.
 * ToList() should return a Vector<String> object.
 * Max() should return the String that is at least as large as the other two.
 * @author arkia
 *
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

  public List<?> toList(Object value)
  {
    return toList(value);
  }
}
