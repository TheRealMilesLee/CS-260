package com.edu.truman.cs260.Hengyi.Inhertance;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest
{

  @Test
  public void testRank()
  {
    Card RankCard = new Card("Queen", "Diamonds");
    int actual = RankCard.getRank();
    int expected = 12;
    assertEquals(expected, actual);
  }

  @Test
  public void testRankString()
  {
    Card StringRankCard = new Card("Queen", "Diamonds");
    String actual = StringRankCard.getRankString();
    String expected = "Queen";
    assertEquals(expected, actual);
  }

  @Test
  public void testSuit()
  {
    Card SuitCard = new Card("Queen", "Diamonds");
    String actual = SuitCard.getSuit();
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
  
  @Test
  public void testCompareNegative()
  {
    Card negativeCompareA = new Card("Queen", "Diamonds");
    Card negativeCompareB = new Card(4,"Spades");
    int actural = negativeCompareA.compareTo(negativeCompareB);
    int expected = -1;
    assertEquals(expected, actural);
  }
  
  @Test
  public void testComparePositive()
  { 
    Card positiveCompareA = new Card(4,"Spades");
    Card positiveCompareB = new Card("Queen", "Diamonds");
    int actural = positiveCompareA.compareTo(positiveCompareB);
    int expected = 1;
    assertEquals(expected,actural);
  }
  
  @Test
  public void testCompareJoker()
  {
    Card JokerTestA = new Card(1,"None");
    Card JokerTestB = new Card(1,"None");
    Card JokerTestC = new Card (4,"Spades");
    //Equal situation
    int Equalactural = JokerTestA.compareTo(JokerTestB);
    int EqualExpected = 0;
    assertEquals(EqualExpected,Equalactural);
    //Joker greater Other situation
    int PositiveActural = JokerTestA.compareTo(JokerTestC);
    int PositiveExpected = 1;
    assertEquals(PositiveExpected,PositiveActural);
    //Other less than Joker situation
    int NegativeActural = JokerTestC.compareTo(JokerTestA);
    int NegativeExpected = -1;
    assertEquals(NegativeExpected, NegativeActural);
  }
}
