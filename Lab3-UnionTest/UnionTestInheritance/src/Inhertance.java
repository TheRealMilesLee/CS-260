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
    Card DigitCardObject = new Card(1,"None");
    System.out.println(DigitCardObject.getRank());
    System.out.println(DigitCardObject.getRankString());
    System.out.println(DigitCardObject.getSuit());
  }

}
