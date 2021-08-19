package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.*;


/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне02", dateFormat.parse("September 1 2012"));
        map.put("Сталлоне03", dateFormat.parse("AUGUST 1 2012"));
        map.put("Сталлоне04", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне05", dateFormat.parse("MAY 1 2012"));
        
        map.put("Сталлоне6", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне7", dateFormat.parse("June 1 2012")); 
        map.put("Сталлоне8", dateFormat.parse("July 1 2012"));
        map.put("Сталлоне9", dateFormat.parse("MAY 1 2012"));
        map.put("Сталлоне10", dateFormat.parse("Jan 1 2012"));
        
        return map;
    }

    public static void removeAllSummerPeople(Map<String, Date> map) {
        
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        
        while(iterator.hasNext()){
            Date d = iterator.next().getValue();

            switch (d.getMonth()){
                case 5:
                case 6:
                case 7: iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}
