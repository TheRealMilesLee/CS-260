package com.edu.truman.cs260.li.design;
import java.util.*;

/**
 * This interface declare the commonality of DoubleTrio.java and IntegerTrio.java
 * max() is to find the maximum among the given value
 * toList() is convert value to a Vector<String> list.
 * @author Hengyi Li.
 */
public interface Trio<T>
{
  public T max();
  public List<T> toList();
}
