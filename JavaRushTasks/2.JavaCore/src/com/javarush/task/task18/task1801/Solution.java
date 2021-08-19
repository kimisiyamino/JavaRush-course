package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String string = bufferedReader.readLine();
        //String string = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1801\\file";
        FileInputStream fileInputStream = new FileInputStream(string);
        int maxByte = 0;
        while(fileInputStream.available() > 0){
            int byte_= fileInputStream.read();
            maxByte = byte_ > maxByte ? byte_ : maxByte;
        }
        fileInputStream.close();

        System.out.println(maxByte);
    }
}
