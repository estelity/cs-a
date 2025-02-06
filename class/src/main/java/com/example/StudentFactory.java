package com.example;
public class StudentFactory
{
  public static void main(String[] args)
  {
    // Part 1
    Student Gage = new Student();
    String name1 = Gage.getName();
    System.out.println(name1);
    
    int grade1 = Gage.getGrade();
    System.out.println(grade1);

    // Part 2
    Student Raya = new Student("Raya");
    String name2 = Raya.getName();
    System.out.println("\n" + name2);

    int grade2 = Raya.getGrade();
    System.out.println(grade2);

    Student Abdul = new Student(11);
    String name3 = Abdul.getName();
    System.out.println("\n" + name3);

    int grade3 = Abdul.getGrade();
    System.out.println(grade3);

    // Part 3
    Student Peter = new Student("Peter", 11);
    Peter.setName("Saahil");
    Peter.nextGrade();
    String name4 = Peter.getName();
    System.out.println("\n" + name4);

    int grade4 = Peter.getGrade();
    System.out.println(grade4);
  }
}