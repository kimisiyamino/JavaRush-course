package com.javarush.task.task22.task2210;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter, false);
        String[] strings = new String[stringTokenizer.countTokens()];
        int i = 0;
        while(stringTokenizer.hasMoreTokens()){
            strings[i++] = stringTokenizer.nextToken();
        }
        return strings;
    }
}
