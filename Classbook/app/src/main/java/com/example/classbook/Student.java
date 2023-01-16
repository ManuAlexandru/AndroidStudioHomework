package com.example.classbook;

import java.util.ArrayList;

public class Student {
    public static ArrayList<Student> studentArrayList=new ArrayList<>();
    public static String StudentEditKey="TheKey";

    private int id;
    private String Name;
    private String Age;
    private String StudentClass;
    private int nrAttendance;


    public Student(int id, String name, String age, String StudentClass, int nrAttendance) {
        this.id = id;
        Name = name;
        Age = age;
        this.StudentClass = StudentClass;
        this.nrAttendance = nrAttendance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String clasa) {
        StudentClass = clasa;
    }

    public int getNrAttendance() {
        return nrAttendance;
    }

    public void setNrAttendance(int nrAbsence) {
        this.nrAttendance = nrAbsence;
    }

    public static Student GetStudentById(int id){
     for(Student student:studentArrayList){
         if(student.getId()==id)
             return student;
     }
     return null;
    }

    public static boolean RemoveStudent(int id){
        for(Student student:studentArrayList){
            if(student.getId()==id)
                return true;
        }

        return false;
    }
}
