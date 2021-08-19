package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Double> map = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileReader fileReader = new FileReader(args[0]);
            while(fileReader.ready())
                stringBuilder.append((char)fileReader.read());

            for(String line : stringBuilder.toString().split(System.lineSeparator())){
                String[] nameValue = line.split(" ");
                if(map.containsKey(nameValue[0])){
                    map.put(nameValue[0], map.get(nameValue[0])+Double.parseDouble(nameValue[1]));
                }else{
                    map.put(nameValue[0], Double.valueOf(nameValue[1]));
                }
            }

            for(Map.Entry<String, Double> e : map.entrySet()){
                System.out.println(e.getKey() + " " + e.getValue());
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
