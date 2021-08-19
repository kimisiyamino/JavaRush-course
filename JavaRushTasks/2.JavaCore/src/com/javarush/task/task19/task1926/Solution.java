package com.javarush.task.task19.task1926;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();

            FileReader fileReader = new FileReader(fileName);

            StringBuilder sb = new StringBuilder();
            while(fileReader.ready()) {
                char c = (char)fileReader.read();
                sb.append(c);
            }
            fileReader.close();

            String[] lines = sb.toString().split(System.lineSeparator());
            for (String s: lines) {
                sb = new StringBuilder(s);
                System.out.println(sb.reverse().toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
