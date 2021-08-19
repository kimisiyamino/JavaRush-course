package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        //String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1807\\file01";

        List<Character> bytes = new ArrayList<>();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        while(fileInputStream.available() > 0) {
            bytes.add((char)fileInputStream.read());
        }
        fileInputStream.close();

        System.out.println(Collections.frequency(bytes, ','));
    }
}
