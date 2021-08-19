package com.javarush.task.task18.task1822;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) {
        try {
            //// test ////
            //args = new String[1];
            //args[0] = "255234523";
            //String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1822\\test";
            //// //// ////

            int inputId = Integer.parseInt(args[0]);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
            while(fileReader.ready()){
                //fileDataBuilder.append(fileReader.readLine()).append("\n");
                String line = fileReader.readLine();
                String id = line.substring(0, line.indexOf(' '));
                if(Integer.parseInt(id) == Integer.parseInt(args[0])){
                    System.out.println(line);
                }
            }

            /*
            Pattern pattern = Pattern.compile("(\\d+) ([a-zA-Z \\-0-9а-яА-Я.]+ \\d+?\\.\\d+ \\d+[\\n\\r]*)");
            Matcher matcher = pattern.matcher(fileData);

            while (matcher.find()){
                if(inputId == Integer.parseInt(matcher.group(1))){
                    System.out.print(matcher.group());
                }
            }*/

            fileReader.close();
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
