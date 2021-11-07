package com.edu.truman.cs260.li.design;
import java.util.Vector;

/**
 * Expresses the commonality of IntegerTrio and DoubleTrio class.
 * Both the ArrayList and the LinkedList implement the interface java.util.List.
 * @author Hengyi Li
 */
public interface Trio
{
  public String max();
  public Vector<String> toList(String valueA, String valueB, String valueC);
}
