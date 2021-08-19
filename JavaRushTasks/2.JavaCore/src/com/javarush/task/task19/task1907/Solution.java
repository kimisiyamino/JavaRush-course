package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            //String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1907\\file";
            StringBuilder stringBuilder = new StringBuilder();
            FileReader fileReader = new FileReader(fileName);
            while(fileReader.ready()){
                stringBuilder.append((char)fileReader.read());
            }

            Matcher matcher = Pattern.compile("\\bworld\\b").matcher(stringBuilder.toString());
            int count = 0;
            while (matcher.find()){
                count++;
            }
            System.out.println(count);

            bufferedReader.close();
            fileReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
