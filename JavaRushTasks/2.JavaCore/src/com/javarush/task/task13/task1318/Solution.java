package com.javarush.task.task13.task1318;

import java.io.*;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) {
        //File fileRead = new File("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task13\\task1318\\file1");

        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();

            File fileRead = new File(fileName);

            FileInputStream fileInputStream = new FileInputStream(fileRead);
            int tempChar;
            while((tempChar = fileInputStream.read()) != -1) {
                System.out.print((char)tempChar);
            }

            fileInputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}