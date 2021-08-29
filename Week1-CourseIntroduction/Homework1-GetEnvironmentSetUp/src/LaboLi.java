import edu.truman.cs260.Li.lab.Student;
import java.util.Scanner;
import java.util.Vector;

public class LaboLi {
    public static void main(String[] args) {
    	// Create three student object for processing.
        Student studentObj1 = new Student();
        Student studentObj2 = new Student();
        Student studentObj3 = new Student();

        // Be ready to input data
        Scanner name = new Scanner(System.in);
        Scanner id = new Scanner(System.in);

        // Get the name of the student.
        System.out.println("What's the name of the student? ");
        studentObj1.setName(name.nextLine());
        studentObj2.setName(name.nextLine());
        studentObj3.setName(name.nextLine());
        
        // Get the id of the student.
        System.out.println("What's the id of the student?");
        studentObj1.setID(id.nextInt());
        studentObj2.setID(id.nextInt());
        studentObj3.setID(id.nextInt());
      
        // Create two vector object for indexing
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
        
        // If the first student id is smaller than the second, then compare the first student id with third student id. 
	        // If the first student id is smaller than the third student, then the smallest id is the first student.
	        // If the first student id is larger than the third student, then the smallest id is the third student.
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
        
        // If the first student id is larger than the second student id, then compare the second student id with the third student id.
	        // If third student id is smaller than second student id, then the smallest id is the third student.
	        // If second student id is larger than third student id, then the smallest id is the second student.
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
        // Close the file to prevent the leak.
        name.close();
        id.close();
    }
}
