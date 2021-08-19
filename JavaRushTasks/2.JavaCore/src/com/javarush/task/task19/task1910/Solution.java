package com.javarush.task.task19.task1910;

import java.io.*;
import java.util.ArrayList;

/* 
Пунктуация
*/

public class Solution {
    public static void main(String[] args) {
       start();
    }

    public static void start(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
            String temp = "";
            String file1 = "";
            while((temp = fileReader.readLine()) != null){
                file1+=temp;
            }
            String modifiedFile1 = file1.replaceAll("[^a-zA-Z0-9 ]+", "");

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));
            fileWriter.write(modifiedFile1);

            bufferedReader.close();
            fileReader.close();
            fileWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
