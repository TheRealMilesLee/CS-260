package com.edu.truman.cs260.Hengyi.Inhertance;

public class Card extends AbstractCard
{
  String rankOfCards = "";
  int rankNumberOfCards = 0;
  String suitOfCards = "";

  public Card(String rank, String suit)
  {
    int looptimes = 0;
    boolean found = false;
    if (rank.equals(AbstractCard.RANKS[15]))
    {
      suitOfCards = AbstractCard.SUITS[4];
    }
    else
    {
      while (!found && looptimes < AbstractCard.RANKS.length)
      {
        if (rank.equals(AbstractCard.RANKS[looptimes]))
        {
          rankOfCards = rank;
          rankNumberOfCards = looptimes;
          found = true;
        }
        else
        {
          looptimes++;
        }
      }
      int loop = 0;
      boolean found_suit = false;
      while (!found_suit && loop < AbstractCard.SUITS.length)
      {
        if (suit.equals(AbstractCard.SUITS[loop]))
        {
          suitOfCards = suit;
          found_suit = true;
        }
        else
        {
          loop++;
        }
      }
    }

  }

  public Card(int rank, String suit)
  {
    if (rank == 1)
    {
      rankNumberOfCards = rank;
      rankOfCards = AbstractCard.RANKS[15];
      suitOfCards = AbstractCard.SUITS[4];
    }
    else if(rank > 1 && rank <= 14)
    {
      int looptime = 0;
      boolean found = false;
      while(!found && looptime < AbstractCard.SUITS.length)
      {
        if(AbstractCard.SUITS[looptime] == suit)
        {
          suitOfCards = suit;
          found = true;
        }
        else
        {
          looptime++;
        }
      }
      rankNumberOfCards = rank;
      rankOfCards = AbstractCard.RANKS[rank];
    }
    else
    {
      System.out.println("Rank number is invalid");
    }
  }

  /**
   * the numerical representation of the rank of the current card ranks have
   * the numerical values 2 = 2, 3 = 3, ..., 10 = 10 Jack = 11, Queen = 12,
   * King = 13, Ace = 14 Joker = 1
   *
   * @return the numerical rank of this card
   */
  @Override
  public int getRank()
  {
    return rankNumberOfCards;
  }

  /**
   * the string representation of the rank of the current card
   *
   * @return the string representation of the rank of this card (must be a
   *         string from Card.RANKS)
   */
  @Override
  public String getRankString()
  {
    return rankOfCards;
  }

  /**
   * the suit of the current card
   *
   * @return the suit of this card (must be a string from Card.SUITS)
   */
  @Override
  public String getSuit()
  {
    return suitOfCards;
  }

  /**
   * Compares this object with the specified object for order. Returns a
   * negative integer, zero, or a positive integer as this object is less
   * than, equal to, or greater than the specified object.
   *
   * @param o the object to be compared.
   *
   * @return a negative integer, zero, or a positive integer as this object is
   *         less than, equal to, or greater than the specified object.
   */
  @Override
  public int compareTo(AbstractCard o)
  {
    if(o.getRank() == 1)
    {
      if(rankNumberOfCards == 1)
      {
        return 0;
      }
      else
      {
        return -1;
      }
    }
    else if(rankNumberOfCards == 1)
    {
      if(o.getRank() == 1)
      {
        return 0;
      }
      else
      {
        return 1;
      }
    }
    else if(rankNumberOfCards < o.getRank())
    {
      if(suitOfCards.compareTo(o.getSuit()) > 0) 
      {
       return 1; 
      }
      else if(suitOfCards.compareTo(o.getSuit()) < 0)
      {
        return -1;
      }
      else
      {
        return -1;
      }
    }
    else if(rankNumberOfCards > o.getRank())
    {
      if(suitOfCards.compareTo(o.getSuit()) > 0) 
      {
       return 1; 
      }
      else if(suitOfCards.compareTo(o.getSuit()) < 0)
      {
        return -1;
      }
      else
      {
        return 1;
      }
    }
    else
    {
      if(suitOfCards.compareTo(o.getSuit()) > 0) 
      {
       return 1; 
      }
      else if(suitOfCards.compareTo(o.getSuit()) < 0)
      {
        return -1;
      }
      else
      {
        return 0;
      }
    }
  }
}
