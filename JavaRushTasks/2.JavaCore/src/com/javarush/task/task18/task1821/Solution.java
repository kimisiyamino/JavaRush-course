package com.javarush.task.task18.task1821;

import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) {
        String fileName = args[0];
        try {
            FileReader fileReader = new FileReader(fileName);
            Map<Integer, Integer> map = new TreeMap<>();

            while(fileReader.ready()){
                int _byte = fileReader.read();

                if(!map.containsKey(_byte)){
                    map.put(_byte, 1);
                }else{
                    map.put(_byte, map.get(_byte) + 1);
                }
            }
            fileReader.close();

            for(Map.Entry<Integer, Integer> m : map.entrySet()){
                System.out.println((char)(int)m.getKey() + " " + m.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
