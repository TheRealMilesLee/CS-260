import com.edu.truman.cs260.li.design.*;

public class InterfaceDesign
{
  public static void main(String[] args)
  {
    String testValueA = "A";
    String testValueB = "B";
    String testValueC = "C";
    SuperTrioClass testSuperTrio = new SuperTrioClass(testValueA, testValueB,
        testValueC);
    String actualTest = testSuperTrio.max();
    System.out.println(actualTest);
    System.out.println(testSuperTrio.toList());
  }

}
