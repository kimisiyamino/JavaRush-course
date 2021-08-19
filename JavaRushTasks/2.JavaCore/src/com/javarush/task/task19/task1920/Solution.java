package com.javarush.task.task19.task1920;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Самый богатый
*/

public class Solution {
    public static void main(String[] args) {
          String fileName = args[0];
        //String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1920\\file";

        try{
            FileReader fileReader = new FileReader(fileName);
            StringBuilder stringBuilder = new StringBuilder();

            while (fileReader.ready()){
                stringBuilder.append((char)fileReader.read());
            }
            Map<String, Double> map = new TreeMap<>();

            String[] entryes = stringBuilder.toString().split("\n");

            for(String entry : entryes){
                String[] keyValue = entry.split(" ");
                String key = keyValue[0];
                Double value = Double.parseDouble(keyValue[1]);

                if(map.get(key) == null){
                    map.put(key, value);
                }else{
                    value+=map.get(keyValue[0]);
                    if(value.toString().length() > 5){
                        value = Double.parseDouble(value.toString().substring(0, 6));
                    }
                    map.put(key, value);
                }
            }
            double maxValue = map.values().iterator().next();

            for(Double value : map.values()){
                if(maxValue < value){
                    maxValue = value;
                }
            }

            for(Map.Entry<String, Double> m : map.entrySet()) {
                if(m.getValue() == maxValue)
                    System.out.println(m.getKey());
            }

            fileReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }



    }
}
