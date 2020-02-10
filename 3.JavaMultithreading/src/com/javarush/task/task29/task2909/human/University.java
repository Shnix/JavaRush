package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {



    private List<Student> students = new ArrayList();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student s : students){
            if(s.getAverageGrade()==averageGrade){
                return s;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student best = null;
        double average = 0;
        for (Student s : students){
            if(s.getAverageGrade()>average){
                average = s.getAverageGrade();
                best = s;}
        }
        return best;
    }

    public Student getStudentWithMinAverageGrade() {
        Student worst = null;
        double average = Double.MAX_VALUE;
        for (Student s : students){
            if(s.getAverageGrade()<average){
                average = s.getAverageGrade();
                worst = s;}
        }
        return worst;
    }

    public void expel(Student student){
        students.remove(student);
    }

    public List getStudents() {
        return students;
    }

    public void setStudents(List students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}