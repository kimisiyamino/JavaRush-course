package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args)  {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();
            //String fileName1 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1908\\file1";
            //String fileName2 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1908\\file2";

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

            StringBuilder stringBuilder = new StringBuilder();

            while(fileReader.ready()){
                stringBuilder.append(fileReader.readLine());
            }

            Matcher matcher = Pattern.compile("(^\\d+ | \\d+$| \\d+ )").matcher(stringBuilder.toString());

            while(matcher.find()){
                fileWriter.write(matcher.group().replaceAll(" ", "") + " ");
            }

            bufferedReader.close();
            fileReader.close();
            fileWriter.flush();
            fileWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
