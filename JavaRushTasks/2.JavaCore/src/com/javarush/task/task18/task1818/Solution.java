package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

            String fileName1 = bf.readLine();
            String fileName2 = bf.readLine();
            String fileName3 = bf.readLine();

            //String fileName1 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1818\\file1";
            //String fileName2 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1818\\file2";
           // String fileName3 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1818\\file3";

            FileInputStream fisFile2 = new FileInputStream(fileName2);
            FileInputStream fisFile3 = new FileInputStream(fileName3);
            FileOutputStream fosFile1 = new FileOutputStream(fileName1);

            String fileData = "";

            StringBuilder stringBuilder = new StringBuilder();

            while(fisFile2.available() > 0){
                char temp = (char)fisFile2.read();
                stringBuilder.append(temp);
            }


            while(fisFile3.available() > 0){
                char temp = (char)fisFile3.read();
                stringBuilder.append(temp);
            }

            fileData = stringBuilder.toString();

            for(int i = 0; i < fileData.length(); i++) {
                fosFile1.write(fileData.charAt(i));
            }

            bf.close();
            fisFile2.close();
            fisFile3.close();
            fosFile1.flush();
            fosFile1.close();

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
