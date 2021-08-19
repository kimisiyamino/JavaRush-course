package com.javarush.task.task17.task1710;

import sun.util.calendar.LocalGregorianCalendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //args = new String[] {"-c", "name", "м", "15/04/1990"};
        start(args);
        //args = new String[] {"-i", "2"};
        //start(args);
    }

    public static void start(String[] args) throws ParseException {
        switch(args[0].charAt(1)){
            case 'c': create(args[1], args[2].toLowerCase().charAt(0), args[3]); break;
            case 'u': update(Integer.parseInt(args[1]), args[2], args[3].charAt(0), args[4]); break;
            case 'd': delete(Integer.parseInt(args[1])); break;
            case 'i': print(Integer.parseInt(args[1])); break;
        }
    }

    public static void create(String name, char gender, String hb) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = simpleDateFormat.parse(hb);
        switch(gender){
            case 'м':   allPeople.add(Person.createMale(name, date));
                        System.out.println(allPeople.size()-1);
                        break;
            case 'ж':   allPeople.add(Person.createFemale(name, date));
                        System.out.println(allPeople.size()-1);
                        break;
        }
    }

    public static void update(int id, String name, char gender, String hb) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = simpleDateFormat.parse(hb);

        switch(gender){
            case 'м': allPeople.set(id, Person.createMale(name, date)); break;
            case 'ж': allPeople.set(id, Person.createFemale(name, date)); break;
        }
    }

    public static void delete(int id){
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDate(null);
    }

    public static void print(int id) throws ParseException {
        String name = allPeople.get(id).getName();
        char g = ' ';

        DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date hb = allPeople.get(id).getBirthDate();
        String todayAsString = dateFormat.format(hb);

        if(allPeople.get(id).getSex() == Sex.MALE){
            g = 'м';
        }else{
            g = 'ж';
        }

        System.out.println(name + " " + g + " " + todayAsString);
    }
}
