package edu.truman.li.cs260.lab5;

/**
 * The type Student.
 */
public class Student
{
  private final int studentID;
  private final String studentName;
  
  /**
   * Instantiates a new Student.
   *
   * @param id   the id
   * @param name the name
   */
  public Student(int id, String name)
  {
    this.studentID = id;
    this.studentName = name;
  }
  
  /**
   * Gets id.
   *
   * @return the id
   */
  int get_id()
  {
    return studentID;
  }
  
  /**
   * Gets name.
   *
   * @return the name
   */
  String get_name()
  {
    return studentName;
  }
}
