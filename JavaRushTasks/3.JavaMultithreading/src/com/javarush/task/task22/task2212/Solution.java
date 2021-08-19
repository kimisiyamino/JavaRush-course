package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        if(telNumber == null || telNumber.equals("") || telNumber.length() < 10) return false;
        Matcher matcher;
        matcher = Pattern.compile("^\\+?\\d+?\\(?\\d+\\)?\\d+-?\\d+-?\\d+$").matcher(telNumber);

        return matcher.find();
    }

    public static void main(String[] args) {
        String telsAll = "+380501234567\n+38(050)1234567\n+38050123-45-67\n050123-4567\n+38)050(1234567\n+38(050)1-23-45-6-7\n050ххх4567\n050123456\n(0)501234567\n";
        String[] tels = telsAll.split("\\n");

        for (String tel : tels){
            System.out.println(checkTelNumber(tel));
        }
    }
}
