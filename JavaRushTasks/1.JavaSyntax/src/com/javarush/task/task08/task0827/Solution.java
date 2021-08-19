package com.javarush.task.task08.task0827;

/* 
Работа с датой
*/

import java.util.Calendar;
import java.util.Date;

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        String[] dateArray = date.split(" ");
        Date date1 = new Date();
        Date date2 = new Date();

        date1.setYear(Integer.parseInt(dateArray[2]) - 1900);
        date1.setDate(Integer.parseInt(dateArray[1]));

        switch(dateArray[0].toUpperCase()){
            case "JAN": date1.setMonth(Calendar.JANUARY); break;
            case "FEB": date1.setMonth(Calendar.FEBRUARY); break;
            case "MAR": date1.setMonth(Calendar.MARCH); break;
            case "APR": date1.setMonth(Calendar.APRIL); break;
            case "MAY": date1.setMonth(Calendar.MAY); break;
            case "JUN": date1.setMonth(Calendar.JUNE); break;
            case "JUL": date1.setMonth(Calendar.JULY); break;
            case "AUG": date1.setMonth(Calendar.AUGUST); break;
            case "SEP": date1.setMonth(Calendar.SEPTEMBER); break;
            case "OCT": date1.setMonth(Calendar.OCTOBER); break;
            case "NOV": date1.setMonth(Calendar.NOVEMBER); break;
            case "DEC": date1.setMonth(Calendar.DECEMBER); break;

            case "JANUARY": date1.setMonth(Calendar.JANUARY); break;
            case "FEBRUARY": date1.setMonth(Calendar.FEBRUARY); break;
            case "MARCH": date1.setMonth(Calendar.MARCH); break;
            case "APRIL": date1.setMonth(Calendar.APRIL); break;
            case "JUNE": date1.setMonth(Calendar.JUNE); break;
            case "JULY": date1.setMonth(Calendar.JULY); break;
            case "AUGUST": date1.setMonth(Calendar.AUGUST); break;
            case "SEPTEMBER": date1.setMonth(Calendar.SEPTEMBER); break;
            case "OCTOBER": date1.setMonth(Calendar.OCTOBER); break;
            case "NOVEMBER": date1.setMonth(Calendar.NOVEMBER); break;
            case "DECEMBER": date1.setMonth(Calendar.DECEMBER); break;

        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);

        Calendar calendar2 = Calendar.getInstance();

        date2.setYear(Integer.parseInt(dateArray[2]) - 1900);
        date2.setMonth(Calendar.JANUARY);
        date2.setDate(0);
        date2.setHours(0);

        calendar2.setTime(date2);

        long clearTime = calendar1.getTimeInMillis() - calendar2.getTimeInMillis();
        int days = (int)(clearTime/=86_400_000L);

       // System.out.println();

        return days % 2 == 1;
        //return calendar1.get(Calendar.DAY_OF_YEAR) % 2 == 1;
    }
}
