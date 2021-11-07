package com.edu.truman.cs260.li.design;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * ToList() should return a Vector<String> object.
 */
public abstract class SuperTrioClass implements Trio
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
  @Override
  public List<Double> toDoubleList()
  {
    LinkedList<Double> doubleValueLinkedList = new LinkedList<>();
    doubleValueLinkedList.add(valueA);
    doubleValueLinkedList.add(valueB);
    doubleValueLinkedList.add(valueC);
    return doubleValueLinkedList;
  }
  @Override
  public List<Integer> toIntegerList()
  {
    ArrayList<Integer> newList = new ArrayList<>();
    newList.add(valueA);
    newList.add(valueB);
    newList.add(valueC);
    return newList;
  }
}
