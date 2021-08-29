import edu.truman.cs260.Li.lab.Student;
import java.util.Scanner;
import java.util.Vector;

public class LaboLi {
    public static void main(String[] args) {
        Student studentObj1 = new Student();
        Student studentObj2 = new Student();
        Student studentObj3 = new Student();

        Scanner name = new Scanner(System.in);
        Scanner id = new Scanner(System.in);

        System.out.println("What's the name of the student? ");
        studentObj1.setName(name.nextLine());
        studentObj2.setName(name.nextLine());
        studentObj3.setName(name.nextLine());
        
        System.out.println("What's the id of the student?");
        studentObj1.setID(id.nextInt());
        studentObj2.setID(id.nextInt());
        studentObj3.setID(id.nextInt());
      

        Vector<Integer> studentIDVector = new Vector<Integer>();
        studentIDVector.addElement(studentObj1.getID());
        studentIDVector.addElement(studentObj2.getID());
        studentIDVector.addElement(studentObj3.getID());

        Vector<String> studentNameVector = new Vector<String>();
        studentNameVector.addElement(studentObj1.getName());
        studentNameVector.addElement(studentObj2.getName());
        studentNameVector.addElement(studentObj3.getName());

        int VectorIndex = 0;
        int smallestID;
        int compareIndex = 0;
        String smallestIdName;

        if (studentIDVector.elementAt(VectorIndex) < studentIDVector.elementAt(VectorIndex + 1)) {
            compareIndex = studentIDVector.elementAt(VectorIndex);
            if (compareIndex < studentIDVector.elementAt(VectorIndex + 2)) {
                smallestID = compareIndex;
                smallestIdName = studentNameVector.elementAt(VectorIndex);
                System.out.println("\nThe lowest id is: " + smallestID + " With corresponding name: " + smallestIdName);
            }
            else if(compareIndex > studentIDVector.elementAt(VectorIndex + 2)){
                smallestID = studentIDVector.elementAt(VectorIndex + 2);
                smallestIdName = studentNameVector.elementAt(VectorIndex + 2);
                System.out.println("\nThe lowest id is: " + smallestID + " With corresponding name: " + smallestIdName);
            }
        }
        else if(studentIDVector.elementAt(VectorIndex) > studentIDVector.elementAt(VectorIndex + 1)){
            compareIndex = studentIDVector.elementAt(VectorIndex + 1);
            if (compareIndex < studentIDVector.elementAt(VectorIndex + 2)) {
                smallestID = compareIndex;
                smallestIdName = studentNameVector.elementAt(VectorIndex + 1);
                System.out.println("\nThe lowest id is: " + smallestID + " With corresponding name: " + smallestIdName);
            }
            else if(compareIndex > studentIDVector.elementAt(VectorIndex + 2)){
                smallestID = studentIDVector.elementAt(VectorIndex + 2);
                smallestIdName = studentNameVector.elementAt(VectorIndex + 2);
                System.out.println("\nThe lowest id is: " + smallestID + " With corresponding name: " + smallestIdName);
            }
        }
        name.close();
        id.close();
    }
}
