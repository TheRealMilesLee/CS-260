import com.edu.truman.cs260.Hengyi.Inhertance.*;
public class Inhertance
{

  public static void main(String[] args)
  {
    Card cardObject = new Card("Queen","Diamonds");
    System.out.println(cardObject.getRank());
    System.out.println(cardObject.getRankString());
    System.out.println(cardObject.getSuit());
    System.out.println();
    
    Card DigitCardObject = new Card(4,"Spades");
    System.out.println(DigitCardObject.getRank());
    System.out.println(DigitCardObject.getRankString());
    System.out.println(DigitCardObject.getSuit());
    System.out.println();
    
    Card Joker = new Card(1,"None");
    System.out.println(Joker.getRank());
    System.out.println(Joker.getRankString());
    System.out.println(Joker.getSuit());
    System.out.println();
    
    System.out.println("The following is the QueenDiamons card compare to 4Spades Card,"
        + "negative is less than, positive is greater than and 0 is equal");
    System.out.println(cardObject.compareTo(DigitCardObject));
    
    System.out.println("The following is the Joker card compare to QueenDiamons Card,"
        + "negative is less than, positive is greater than and 0 is equal");
    System.out.println(cardObject.compareTo(DigitCardObject));
  }

}
