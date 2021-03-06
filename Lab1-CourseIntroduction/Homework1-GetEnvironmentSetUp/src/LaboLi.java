import edu.truman.cs260.Li.lab.Student;
import java.util.Scanner;
import java.util.Vector;

/**
 * This is the main class.
 * @author Hengyi Li
 * Finished at August.30.2021
 * Copyright (c) 2021 Hengyi Li. All rights reserved.
 */
public class LaboLi {
    public static void main(String[] args) {
        
    	// Set two constant for the compare the minimum and maximum values of the student. 
    	final int MAX = Integer.MAX_VALUE;
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

        // Create two vector only for indexing the ID compare and the corresponding name.
        Vector<Integer> studentIDVector = new Vector<Integer>();
        studentIDVector.addElement(studentObj1.getID());
        studentIDVector.addElement(studentObj2.getID());
        studentIDVector.addElement(studentObj3.getID());

        Vector<String> studentNameVector = new Vector<String>();
        studentNameVector.addElement(studentObj1.getName());
        studentNameVector.addElement(studentObj2.getName());
        studentNameVector.addElement(studentObj3.getName());

        // Two integer values for compare the minimum and maximum of the student id value, they'll be cover during the loop.
        int largest = MIN;
        int smallest = MAX;
        // This string value is only for output the minimum student ID corresponding name       
        String SmallestName = " ";
        // Indexing through all the studentIDVector and locate the minimum
        for(int loop = 0; loop < studentIDVector.size(); loop++){
            if(studentIDVector.elementAt(loop) < smallest){
                smallest = studentIDVector.elementAt(loop);
                SmallestName = studentNameVector.elementAt(loop);
            }
            else if(studentIDVector.elementAt(loop) > largest){
                largest = studentIDVector.elementAt(loop);
            }
        }
        // Output the minimum value of the student information.
        System.out.println("The student " + SmallestName + " Has the minimum ID: " + smallest);
        // Close the file to prevent the leak.
        name.close();
        id.close();
    }
}
