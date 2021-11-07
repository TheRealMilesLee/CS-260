package com.edu.truman.cs260.li.design;

import static org.junit.Assert.*;
import java.util.Vector;

import org.junit.Test;

public class TrioTest
{
  
  @Test
  public void testMax()
  {
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
