package com.javarush.task.task18.task1817;

import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) {
        try{
            //String testFile = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1817\\file";
            FileReader fileReader = new FileReader(args[0]);
            int charCount = 0;
            int spaceCount = 0;

            while(fileReader.ready()){
                int input = fileReader.read();
                charCount++;
                if(input == 32)
                    spaceCount++;
            }

            System.out.printf("%.2f", (double)spaceCount/charCount*100);

            fileReader.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
