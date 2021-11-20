package edu.truman.li.cs260.lab5;
public class Student
{
  private final int studentID;
  private final String studentName;
  public Student(int id, String name)
  {
    this.studentID = id;
    this.studentName = name;
  }
  int get_id()
  {
    return studentID;
  }
  String get_name()
  {
    return studentName;
  }
}
