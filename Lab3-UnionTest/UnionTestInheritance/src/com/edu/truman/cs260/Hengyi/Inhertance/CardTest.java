package com.edu.truman.cs260.Hengyi.Inhertance;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest
{

  @Test
  public void testRank()
  {
    Card c = new Card("Queen", "Diamonds");
    int actual = c.getRank();
    int expected = 12;

    assertEquals(expected, actual);

  }

  @Test
  public void testRankString()
  {
    Card c = new Card("Queen", "Diamonds");
    String actual = c.getRankString();
    String expected = "Queen";
    assertEquals(expected, actual);
  }

  @Test
  public void testSuit()
  {
    Card c = new Card("Queen", "Diamonds");
    String actual = c.getSuit();
    String expected = "Diamonds";
    assertEquals(expected, actual);

  }

  @Test
  public void testJoker()
  {
    Card Joker = new Card(1, "None");
    String actual = Joker.getSuit();
    String expected = "None";
    assertEquals(expected, actual);
    int actualRankInt = Joker.getRank();
    int expectedRankInt = 1;
    assertEquals(expectedRankInt, actualRankInt);
    String acturalRankString = Joker.getRankString();
    String expectedRankString = "Joker";
    assertEquals(expectedRankString, acturalRankString);
    // Test Output name of the Joker
    String actualNameOutPut = Joker.toString();
    String expectedNameOutPut = "J";
    assertEquals(expectedNameOutPut, actualNameOutPut);
  }
  
  @Test
  public void testPrintObjectName()
  {
    Card NameObjectTest = new Card("Queen", "Diamonds");
    String actural = NameObjectTest.toString();
    String expected = "12D";
    assertEquals(expected, actural);
  }
  
  @Test
  public void testPrintObjectInvalidCard()
  { 
    Card InvalidCardTest = new Card("invalid card", "invalid card");
    String actual = InvalidCardTest.toString();
    String expected = "invalid card";
    assertEquals(expected, actual);
    
    Card InvalidCardNumermalTest = new Card(99, "invalid card");
    String actualNumermal = InvalidCardNumermalTest.toString();
    String expectedNumermal = "invalid card";
    assertEquals(expectedNumermal, actualNumermal);
    
  }
  
  /*
  @Test
  public void testCompareNegative()
  {
    fail("Not yet implemented");

    // create two Card objects with appropriate parameters
    // now test the two objects by using the compareTo function
    // compare the two objects in a way so that the
    // expected value is negative

  }

  @Test
  public void testComparePositive()
  {
    fail("Not yet implemented");

    // create two Card objects with appropriate parameters
    // now test the two objects by using the compareTo function
    // compare the two objects in a way so that the
    // expected value is positive

  }

  @Test
  public void testCompareJoker()
  {
    fail("Not yet implemented");

    // see the last section of the sample input/output
    // in the attached assignment description
    // create a joker card and test the
    // compareTo function by creating another object
  }
*/
}
