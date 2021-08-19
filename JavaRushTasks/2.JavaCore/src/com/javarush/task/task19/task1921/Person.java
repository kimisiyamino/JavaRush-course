package com.javarush.task.task19.task1921;

import java.util.Date;

public class Person {
    private String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' + ", birthDate=" + birthDate.getDate() + " " + (birthDate.getMonth()+1) + " " + birthDate.getYear() + "}\n";
    }
}
