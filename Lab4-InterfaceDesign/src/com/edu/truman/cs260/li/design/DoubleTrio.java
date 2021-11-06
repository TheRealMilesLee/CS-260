package com.edu.truman.cs260.li.design;
import java.util.LinkedList;
import java.util.List;

/** Objects of this class hold three double values. */
public class DoubleTrio
{
  private double doubleValueA;
  private double doubleValueB;
  private double doubleValueC;

  /**
   * Create a new object, initialized with the given values.
   * @param alpha is the first double value
   * @param beta is the second double value
   * @param gamma is the third double value
   */
  public DoubleTrio(double alpha, double beta, double gamma)
  {
    doubleValueA = alpha;
    doubleValueB = beta;
    doubleValueC = gamma;
  }

  /**
   * Take the values in the object and put them in a list.
   * @return the new list
   */
  public List<Double> toList()
  {
    LinkedList<Double> doubleValueLinkedList = new LinkedList<>();
    doubleValueLinkedList.add(doubleValueA);
    doubleValueLinkedList.add(doubleValueB);
    doubleValueLinkedList.add(doubleValueC);
    return doubleValueLinkedList;
  }

  /**
   * Find and return the maximum of the three doubles, as a wrapper.
   * @return the maximum, wrapped
   */
  public Double max()
  {
    if (doubleValueA >= doubleValueB)
    {
      if (doubleValueA >= doubleValueC)
      {
        return doubleValueA;
      }
    }
    else if (doubleValueB >= doubleValueC)
    {
      return doubleValueB;
    }
    return doubleValueC;
  }
}
