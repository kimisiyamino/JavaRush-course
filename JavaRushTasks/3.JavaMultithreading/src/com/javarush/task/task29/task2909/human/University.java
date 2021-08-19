package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class University{
    private List<Student> students = new ArrayList<>();

    String name;
    int age;


    public University(String name, int age) {
        this.name = name;
        this.age = age;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(Student student : students){
            if(student.getAverageGrade() >= averageGrade){
                return student;
            }
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getAverageGrade))
                .orElse(null);
    }

    public Student getStudentWithMinAverageGrade() {
        return students.stream()
                .min((o1, o2) -> {
                    if(o1.getAverageGrade() > o2.getAverageGrade()) {
                        return 1;
                    }else if(o1.getAverageGrade() < o2.getAverageGrade()) {
                        return -1;
                    }else{
                        return 0;
                    }
                })
                .orElse(null);
    }

    public void expel(Student student){
        students.remove(student);
    }
}