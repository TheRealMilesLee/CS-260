package com.edu.truman.cs260.Hengyi.Inhertance;

public class Card extends AbstractCard
{
  private String rankOfCards = "";
  private int rankNumberOfCards = 0;
  private String suitOfCards = "";
/**
 * This constructor is to initialize the Card with the string rank name and the string suit name
 * @param rank is the string value of the rank of the card
 * @param suit is a string value that represents the suit of the card.
 */
  public Card(String rank, String suit)
  {
    int looptimes = 0;
    boolean found = false;
    /**
     * If the rank is AbstractCard.RANKS[15] then any  valid suit from AbstractCard.SUITS can be 
     * given but the card’s suit will be set to AbstractCard.SUITS[4] 
     * */
    if (rank.equals(AbstractCard.RANKS[15]))
    {
      suitOfCards = AbstractCard.SUITS[4];
    }
    else
    {
      /**
       * Find the rank of the cards that corresponds with the AbstractCard.RANKS
       */
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
      /**
       * Find the suits that corresponds to the AbstractCard.SUITS.
       */
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

  /**
   * This constructor is to initialize the rank and the suit of the card by using the int rank value 
   * and the string suit value.
   * @param rank is a int value that stores the rank of the card, satisfying 1 <= rank <= 14, where
   *  1 for joker, 2 for 2, 3 for 3, .., 10 for 10, 11 for jack, 12 for queen, 13 for king, 14 for ace
   * @param suit is a string value that stores the suit of the card.
   */
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
   * This is the numerical representation of the rank of the current card ranks have
   * the numerical values 2 = 2, 3 = 3, ..., 10 = 10 Jack = 11, Queen = 12,
   * King = 13, Ace = 14 Joker = 1
   * @return the numerical rank of this card
   */
  @Override
  public int getRank()
  {
    return rankNumberOfCards;
  }

  /**
   * This is the string representation of the rank of the current card
   * @return the string representation of the rank of this card
   */
  @Override
  public String getRankString()
  {
    return rankOfCards;
  }

  /**
   * This function is to get the suit of the current card
   * @return the suit of this card (must be a string from Card.SUITS)
   */
  @Override
  public String getSuit()
  {
    return suitOfCards;
  }

  /**
   * Compares this object with the specified object for order.
   * @param o the object to be compared.
   * @return -1 for less than, return 0 as equal, return 1 as greater than
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
