import com.edu.truman.cs260.li.design.*;

public class InterfaceDesign
{
  public static void main(String[] args)
  {
    String testValueA = "ABCD";
    String testValueB = "EFGH";
    String testValueC = "a";
    SuperTrioClass testSuperTrio = new SuperTrioClass(testValueA, testValueB,
        testValueC);
    //Test the max value that the superTrio return. It should be lower case a
    String actualTest = testSuperTrio.max();
    System.out.println(actualTest);
    //Test the toList function. It should be print out the List that in.
    System.out.println(testSuperTrio.toList());
  }

}
