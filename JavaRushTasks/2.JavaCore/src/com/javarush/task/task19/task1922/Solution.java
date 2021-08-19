package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
//        words.add("А");
//        words.add("Б");
//        words.add("В");

    }

    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            //String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1922\\file.txt";
            String fileName = bufferedReader.readLine();
            bufferedReader.close();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while(fileReader.ready()){
                String line = fileReader.readLine();

                int count = 0;
                for(String word : words) {
                    Matcher matcher = Pattern.compile("\\b" + word + "\\b").matcher(line);

                    while (matcher.find()) {
                        count++;
                    }

                }
                if (count == 2) System.out.println(line);
            }

            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
