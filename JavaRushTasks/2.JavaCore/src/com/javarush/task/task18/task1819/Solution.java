package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();

            //String fileName1 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1819\\file1";
            //String fileName2 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1819\\file2";


            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            StringBuilder stringBuilder = new StringBuilder();

            while (fileReader.ready()){
                stringBuilder.append(fileReader.readLine());
            }
            fileReader.close();

            String file1 = stringBuilder.toString();

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName1));
            fileReader = new BufferedReader(new FileReader(fileName2));

            while (fileReader.ready()){
                fileWriter.write(fileReader.readLine());
            }
            fileWriter.write(file1);

            bufferedReader.close();
            fileReader.close();
            fileWriter.flush();
            fileWriter.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
