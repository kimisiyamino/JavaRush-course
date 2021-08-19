package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            String temp = "";
            String fileData = "";

            while(true){
                temp = bufferedReader.readLine();
                if (temp.equals("exit")){
                    fileData += "\n" + "exit";
                    break;
                }
                fileData += "\n" + temp;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(fileData);


            bufferedReader.close();
            writer.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
