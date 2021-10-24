import com.edu.truman.cs260.Hengyi.Inhertance.*;
public class Inhertance
{

  public static void main(String[] args)
  {
    Card card1 = new Card("Queen","Diamonds");
    System.out.println(card1.getRank());
    System.out.println(card1.getRankString());
    System.out.println(card1.getSuit());
    System.out.println(card1);
    System.out.println();
    
    Card card2 = new Card("4","Spades");
    System.out.println(card1.compareTo(card2));
    System.out.println(card2.compareTo(card1));
    System.out.println();
    
    Card card3 = new Card("Jack","Spades");
    System.out.println(card2.compareTo(card3));
    System.out.println(card3.compareTo(card3));
    System.out.println(card3.getRank());
    System.out.println(card3.getSuit());
    System.out.println();
    
    Card Joker = new Card(1,"None");
    System.out.println(Joker);
    System.out.println(Joker.getRankString());
    System.out.println(Joker.getRank());
    System.out.println(Joker.getSuit());
    System.out.println(card3.compareTo(Joker));
  }

}
