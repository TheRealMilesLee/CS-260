package edu.truman.cs260.Li.lab;

/**
 * This class is to manage the student id and the name of the student.
 * @author Hengyi Li.
 */
public class Student {
    private int id;
    private String name;

    /**
     * This function is to set the name of the student.
     * @param n is the name of the student.
     */
    public void setName(String n) {
        name = n;
    }
    /**
     * This function is to get the name of the student.
     * @return the name of the student.
     */
    public String getName() {
        return name;
    }
    /**
     * This function is to set the id of the student.
     * @param id_param is the id of the student
     */
    public void setID(int id_param) {
        id = id_param;
    }
    /**
     * this function is to get the id of the student.
     * @return the id of the student.
     */
    public int getID() {
        return id;
    }
}
