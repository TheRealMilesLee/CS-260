package com.edu.truman.cs260.li.design;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

import org.junit.Test;

public class TrioTest
{

  @Test
  public void testMax()
  {
    DoubleTrio testDoubleTrio = new DoubleTrio(1.0, 2.0, 3.0);
    double doubleActual = testDoubleTrio.max();
    double doubleExpected = 3.0;
    double delta = 0.0;
    assertEquals(doubleExpected, doubleActual, delta);
    IntegerTrio testIntTrio = new IntegerTrio(1, 2, 3);
    int intActual = testIntTrio.max();
    int intExpected = 3;
    int Intdelta = 0;
    assertEquals(intExpected, intActual, Intdelta);
    String testValueA = "A";
    String testValueB = "B";
    String testValueC = "C";
    SuperTrioClass testSuperTrio = new SuperTrioClass(testValueA, testValueB, testValueC);
    String actualTest = testSuperTrio.max();
    String expectedTest = "C";
    assertEquals(expectedTest, actualTest);
  }

  @Test
  public void testToList()
  {
    LinkedList<Double> doubleValueLinkedList = new LinkedList<>();
    doubleValueLinkedList.add(1.0);
    doubleValueLinkedList.add(2.0);
    doubleValueLinkedList.add(3.0);
    DoubleTrio testDoubleTrio = new DoubleTrio(1.0, 2.0, 3.0);
    LinkedList<Double> doubleActual = testDoubleTrio.toList();
    LinkedList<Double>  doubleExpected = doubleValueLinkedList;
    assertEquals(doubleExpected, doubleActual);
    ArrayList<Integer> newList = new ArrayList<>();
    newList.add(1);
    newList.add(2);
    newList.add(3);
    IntegerTrio testIntTrio = new IntegerTrio(1, 2, 3);
    ArrayList<Integer> intActual = testIntTrio.toList();
    ArrayList<Integer>  intExpected = newList;
    assertEquals(intExpected, intActual);
    String testValueA = "A";
    String testValueB = "B";
    String testValueC = "C";
    Vector<String> testList = new Vector<>();
    testList.add(testValueA);
    testList.add(testValueB);
    testList.add(testValueC);
    SuperTrioClass testSuperTrio = new SuperTrioClass(testValueA, testValueB, testValueC);
    Vector<String> expectedList = testList;
    Vector<String> actualList = testSuperTrio.toList();
    assertEquals(expectedList, actualList);
  }

}
