package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
       // args = new String[1];
       // args[0] = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1921\\file";
        StringBuilder stringBuilder = new StringBuilder();

        try(FileReader reader = new FileReader(args[0])){
            while(reader.ready()){
                char c = (char)reader.read();
                if(c != '\r' && c != '\n')
                  stringBuilder.append(c);
                if(c == '\n' || !reader.ready()){
                    String[] s = stringBuilder.toString().split(" ");

                  //  System.out.println(Arrays.toString(s));

                    if(s.length == 6){
                        Calendar cal = new GregorianCalendar(Integer.parseInt(s[5]), getMon(Integer.parseInt(s[4])), Integer.parseInt(s[3]));
                      //  System.out.println(cal.getTime());
                       // System.out.println(cal.getTimeInMillis());
                        PEOPLE.add(new Person(s[0] + " " + s[1] + " " + s[2], new Date(cal.getTimeInMillis())));
                    }else if(s.length == 4){
                        Calendar cal = new GregorianCalendar(Integer.parseInt(s[3]), getMon(Integer.parseInt(s[2])), Integer.parseInt(s[1]));
                        PEOPLE.add(new Person(s[0], new Date(cal.getTimeInMillis())));
                    }else if(s.length == 5){
                        Calendar cal = new GregorianCalendar(Integer.parseInt(s[4]), getMon(Integer.parseInt(s[3])), Integer.parseInt(s[2]));
                        PEOPLE.add(new Person(s[0] + " " + s[1], new Date(cal.getTimeInMillis())));
                    }

                    stringBuilder = new StringBuilder();
                }

            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }

      //  System.out.println(PEOPLE);
    }

    public static int getMon(int num){
        switch (num){
            case 1: return Calendar.JANUARY;
            case 2: return Calendar.FEBRUARY;
            case 3: return Calendar.MARCH;
            case 4: return Calendar.APRIL;
            case 5: return Calendar.MAY;
            case 6: return Calendar.JUNE;
            case 7: return Calendar.JULY;
            case 8: return Calendar.AUGUST;
            case 9: return Calendar.SEPTEMBER;
            case 10: return Calendar.OCTOBER;
            case 11: return Calendar.NOVEMBER;
            case 12: return Calendar.DECEMBER;
            default: return -1;
        }
    }
}
