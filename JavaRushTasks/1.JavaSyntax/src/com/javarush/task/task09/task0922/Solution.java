package com.javarush.task.task09.task0922;

/* 
Какое сегодня число?
*/

import java.text.SimpleDateFormat;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        String inputString = new Scanner(System.in).nextLine();
        String[] inputData = inputString.split("-");
        SimpleDateFormat date = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

        Date dated = new Date();
        dated.setYear(Integer.parseInt(inputData[0]) - 1900);
        switch(inputData[1]){
            case "01": dated.setMonth(Calendar.JANUARY); break;
            case "02": dated.setMonth(Calendar.FEBRUARY); break;
            case "03": dated.setMonth(Calendar.MARCH); break;
            case "04": dated.setMonth(Calendar.APRIL); break;
            case "05": dated.setMonth(Calendar.MAY); break;
            case "06": dated.setMonth(Calendar.JUNE); break;
            case "07": dated.setMonth(Calendar.JULY); break;
            case "08": dated.setMonth(Calendar.AUGUST); break;
            case "09": dated.setMonth(Calendar.SEPTEMBER); break;
            case "10": dated.setMonth(Calendar.OCTOBER); break;
            case "11": dated.setMonth(Calendar.NOVEMBER); break;
            case "12": dated.setMonth(Calendar.DECEMBER); break;
        }
        Calendar calendar = Calendar.getInstance();
        dated.setDate(Integer.parseInt(inputData[2]));


        System.out.println(date.format(dated).toUpperCase());
    }
}
