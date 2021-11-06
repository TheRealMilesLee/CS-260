package com.edu.truman.cs260.li.design;
import java.util.Vector;
/**
 * This class should contain three Strings. ToList() should return a
 * Vector<String> object. Max() should return the String that is at least as
 * large as the other two When compared using the compareTo() method of the
 * String class.
 *
 * @author arkia
 *
 */
public class SuperTrioClass implements Trio
{
  public void max()
  {

  }

  public Vector<String> toList(Object value)
  {
    Vector<String> elementsList = new Vector<>();
    elementsList.add(value);
    return elementsList;
  }
}
