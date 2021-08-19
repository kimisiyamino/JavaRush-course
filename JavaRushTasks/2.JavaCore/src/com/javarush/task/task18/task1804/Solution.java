package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
           // String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1804\\f";
            bufferedReader.close();

            FileInputStream fileReader = new FileInputStream(fileName);
            byte[] bytes = new byte[fileReader.available()];
            fileReader.read(bytes);
            fileReader.close();

            Map<Byte, Integer> set = new HashMap<>();

            for(byte b : bytes){
                if(!set.containsKey(b)){
                    set.put(b, 1);
                }else{
                    set.put(b, set.get(b)+1);
                }
            }

            int min = set.entrySet().stream().min(Map.Entry.comparingByValue()).get().getValue();

//            System.out.println("Bytes: ");
//            for(Map.Entry<Byte, Integer> s : set.entrySet()){
//                char c = (char)(byte)s.getKey();
//                System.out.println(c + " " + s.getKey() + " " + s.getValue());
//            }
//
//            System.out.println("Min: " + min + "\n\n\n");


            for(Map.Entry<Byte, Integer> s : set.entrySet()) {
                if (s.getValue().equals(min)) {
                    System.out.print(s.getKey() + " ");
                }
            }




        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
