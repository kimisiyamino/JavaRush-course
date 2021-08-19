package com.javarush.task.task07.task0715;

/* 
Продолжаем мыть раму
*/
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");
        
        list.add(1, "именно");
        list.add(3, "именно");
        list.add(5, "именно");
        for(String s : list)
            System.out.println(s);
    }
}
