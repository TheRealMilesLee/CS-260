import edu.truman.cs260.Li.lab.Student;
import java.util.Scanner;
import java.util.Vector;

public class LaboLi {
    public static void main(String[] args) {
        final int MAX = 100;
        final int MIN = 0;
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

        Vector<Integer> studentIDVector = new Vector<Integer>();
        studentIDVector.addElement(studentObj1.getID());
        studentIDVector.addElement(studentObj2.getID());
        studentIDVector.addElement(studentObj3.getID());

        Vector<String> studentNameVector = new Vector<String>();
        studentNameVector.addElement(studentObj1.getName());
        studentNameVector.addElement(studentObj2.getName());
        studentNameVector.addElement(studentObj3.getName());

        int largest = MIN;
        int smallest = MAX;
        String SmallestName = " ";
        for(int loop = 0; loop < studentIDVector.size(); loop++)
        {
            if(studentIDVector.elementAt(loop) < smallest)
            {
                smallest = studentIDVector.elementAt(loop);
                SmallestName = studentNameVector.elementAt(loop);
            }
            else if(studentIDVector.elementAt(loop) > largest)
            {
                largest = studentIDVector.elementAt(loop);
            }
        }
        System.out.println("The student " + SmallestName + " Has the minimum ID: " + smallest);
        // Close the file to prevent the leak.
        name.close();
        id.close();
    }
}
