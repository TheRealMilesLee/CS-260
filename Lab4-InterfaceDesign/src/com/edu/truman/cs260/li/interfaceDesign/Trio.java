package com.edu.truman.cs260.li.interfaceDesign;

import java.util.List;

/**
 * Expresses the commonality of IntegerTrio and DoubleTrio class. Both the
 * ArrayList and the LinkedList implement the interface java.util.List.
 * @author Hengyi Li
 */
public interface Trio
{
  public void Max();
  public List<Trio> toList();
}
