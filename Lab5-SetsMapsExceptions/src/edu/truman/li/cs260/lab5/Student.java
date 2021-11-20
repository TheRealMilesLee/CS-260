package edu.truman.li.cs260.lab5;

public class Student
{
  private int st_id;
  private String name;
  public Student(int id, String name)
  {
    this.st_id = id;
    this.name = name;
  }
  
  int get_id() { return st_id; }
  String get_name() { return name;}
}
