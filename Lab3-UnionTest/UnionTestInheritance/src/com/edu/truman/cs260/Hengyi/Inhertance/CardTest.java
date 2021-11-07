package com.edu.truman.cs260.Hengyi.Inhertance;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest
{

  /**
   * This is testing the numeric rank value is valid or not.
   * Should return the numeric value of the corresponding rank
   */
  @Test
  public void testNumericRank()
  {
    Card RankCard = new Card("Queen", "Diamonds");
    int actual = RankCard.getRank();
    int expected = 12;
    assertEquals(expected, actual);
    Card RankNumericCard = new Card(4, "Spades");
    int acturalNumeric = RankNumericCard.getRank();
    int expectedNumeric = 4;
    assertEquals(expectedNumeric, acturalNumeric);
  }

  /**
   * This is testing the string, which is the name of the rank.
   * Should return the string name of the rank of the cards.
   */
  @Test
  public void testRankString()
  {
    Card StringRankCardA = new Card("Queen", "Diamonds");
    String actual = StringRankCardA.getRankString();
    String expected = "Queen";
    assertEquals(expected, actual);
    Card StringRankCardB = new Card(4, "Spades");
    String actualString = StringRankCardB.getRankString();
    String expectedString = "4";
    assertEquals(expectedString, actualString);
    Card StringRankCardC = new Card(12, "Spades");
    String actualStringB = StringRankCardC.getRankString();
    String expectedStringB = "Queen";
    assertEquals(expectedStringB, actualStringB);
  }

  /**
   * This function is to test the suit of the card
   * It should return the suit name of the card
   */
  @Test
  public void testSuit()
  {
    Card SuitCard = new Card("Queen", "Diamonds");
    String actual = SuitCard.getSuit();
    String expected = "Diamonds";
    assertEquals(expected, actual);
  }

  /**
   *  This test is exclusively for testing Joker situation
   *  Tests the getSuit, getRank, getRankString
   */
  @Test
  public void testJoker()
  {
    Card Joker = new Card(1, "None");
    String actual = Joker.getSuit();
    String expected = "None";
    // Test the numeric value of the joker
    assertEquals(expected, actual);
    int actualRankInt = Joker.getRank();
    int expectedRankInt = 1;
    //Test the String name of the joker
    assertEquals(expectedRankInt, actualRankInt);
    String acturalRankString = Joker.getRankString();
    String expectedRankString = "Joker";
    assertEquals(expectedRankString, acturalRankString);
    // Test Output name of the Joker
    String actualNameOutPut = Joker.toString();
    String expectedNameOutPut = "J";
    assertEquals(expectedNameOutPut, actualNameOutPut);
  }

  /**
   * This function is to test the print out the object name
   */
  @Test
  public void testPrintObjectName()
  {
    Card NameObjectTest = new Card("Queen", "Diamonds");
    String actural = NameObjectTest.toString();
    String expected = "12D";
    assertEquals(expected, actural);
  }

  /**
   * This function is to test the invalid card situation
   */
  @Test
  public void testPrintObjectInvalidCard()
  {
    Card InvalidCardTest = new Card("invalid card", "invalid card");
    String actual = InvalidCardTest.toString();
    String expected = "invalid card";
    assertEquals(expected, actual);
    //Situation that numeric is also invalid
    Card InvalidCardNumericalTest = new Card(99, "invalid card");
    String actualNumerical = InvalidCardNumericalTest.toString();
    String expectedNumerical = "invalid card";
    assertEquals(expectedNumerical, actualNumerical);
  }

  /**
   * This function is to test that card a is smaller than card b
   */
  @Test
  public void testCompareNegative()
  {
    Card negativeCompareA = new Card("Queen", "Diamonds");
    Card negativeCompareB = new Card(4,"Spades");
    int actural = negativeCompareA.compareTo(negativeCompareB);
    int expected = -1;
    assertEquals(expected, actural);
  }

  /**
   * This function is to test that the card a is greater than card b
   */
  @Test
  public void testComparePositive()
  {
    Card positiveCompareA = new Card(4,"Spades");
    Card positiveCompareB = new Card("Queen", "Diamonds");
    int actural = positiveCompareA.compareTo(positiveCompareB);
    int expected = 1;
    assertEquals(expected,actural);
  }

  /**
   * This function is to test the compare working on the joker situation
   */
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
