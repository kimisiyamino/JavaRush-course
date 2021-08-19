package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            //String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1924\\file";
            String file;
            StringBuilder stringBuilder = new StringBuilder();

            FileReader fileReader = new FileReader(fileName);

            while(fileReader.ready()){
                stringBuilder.append((char)fileReader.read());
            }

            file = stringBuilder.toString();

            Pattern pattern = Pattern.compile("\\b\\d+\\b");
            Matcher matcher = pattern.matcher(file);

            while (matcher.find()) {
                int num = Integer.parseInt(matcher.group());
                if (map.containsKey(num)) {
                    //System.out.println(matcher.start() + " - " + matcher.end() + " : " + matcher.group());
                    //file = file.replaceFirst(file.substring(matcher.start(), matcher.end()), map.get(Integer.parseInt(matcher.group())));
                    file = file.replaceFirst("\\b" + matcher.group() + "\\b", map.get(num));
                    //matcher = pattern.matcher(file);
                }
            }

            System.out.println(file);

            fileReader.close();
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
