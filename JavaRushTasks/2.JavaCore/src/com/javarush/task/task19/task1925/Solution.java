package com.javarush.task.task19.task1925;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) {
        //args[0] = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1925\\file1";
        //args[1] = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1925\\file2";

        try {
            FileReader fileReader = new FileReader(args[0]);
            FileWriter fileWriter = new FileWriter(args[1]);

            StringBuilder stringBuilder = new StringBuilder();

            while(fileReader.ready()){
                stringBuilder.append((char)fileReader.read());
            }
            String[] words = stringBuilder.toString().replaceAll(System.lineSeparator(), " ").split(" ");

            stringBuilder = new StringBuilder();

            for (String word : words) {
                if (word.length() > 6) {
                    stringBuilder.append(word).append(",");
                }
            }
            String file = stringBuilder.toString();
            fileWriter.write(file.substring(0, file.length()-1));

            fileWriter.flush();
            fileWriter.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
