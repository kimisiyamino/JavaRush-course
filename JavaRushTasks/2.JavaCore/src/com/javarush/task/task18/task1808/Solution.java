package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String fileName1 = "";
        String fileName2 = "";
        String fileName3 = "";
        try {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
            fileName3 = bufferedReader.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }

        // = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1808\\file1";
        //fileName2 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1808\\file2";
        //fileName3 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1808\\file3";

        List<Integer> bytes = new ArrayList<>();
        int firstSize = 0;
        
        try{
            FileInputStream fileInputStream = new FileInputStream(fileName1);
            FileOutputStream fileOutputStream1 = new FileOutputStream(fileName2);
            FileOutputStream fileOutputStream2 = new FileOutputStream(fileName3);
            
            while(fileInputStream.available() > 0){
                bytes.add(fileInputStream.read());
            }
            fileInputStream.close();

            if(bytes.size() % 2 == 1){
                firstSize = bytes.size()/2+1;
            }else {
                firstSize = bytes.size()/2;
            }

            for (int i = 0; i < firstSize; i++) {
                fileOutputStream1.write(bytes.get(i));
            }
            for (int i = firstSize; i < bytes.size(); i++) {
                fileOutputStream2.write(bytes.get(i));
            }

            fileOutputStream1.close();
            fileOutputStream2.close();

            
        }catch(IOException e){
            e.printStackTrace();
        }     
        
    }
}
