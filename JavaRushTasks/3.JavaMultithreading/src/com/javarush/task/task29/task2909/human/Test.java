package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        University university = new University("RUDN", 100);
        List<Student> students = new ArrayList<>();

        students.add(new Student("Max", 21, 204));
        students.add(new Student("Ann", 25, 305));
        students.add(new Student("Eleonora", 26, 1));
        students.add(new Student("Oleg", 20, 325));
        students.add(new Student("Olga", 22, 350));

        university.setStudents(students);

        System.out.println("Min: " + university.getStudentWithMinAverageGrade().getName());
        System.out.println("Max: " + university.getStudentWithMaxAverageGrade().getName());

        StudentsDataBase.students = students;
        StudentsDataBase.removeStudent(1);

        StudentsDataBase.students.forEach(System.out::println);
    }
}
