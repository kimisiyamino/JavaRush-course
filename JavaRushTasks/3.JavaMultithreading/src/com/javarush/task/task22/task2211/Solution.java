package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
Смена кодировки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //System.out.println(Arrays.toString(args));

       // String s1 = "D:\\JavaRush\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task22\\task2211\\file1Win";
       // String s2 = "D:\\JavaRush\\JavaRushTasks\\3.JavaMultithreading\\src\\com\\javarush\\task\\task22\\task2211\\file2UTF";

        /*
        SortedMap<String, Charset> map = Charset.availableCharsets();
        for(Map.Entry<String, Charset> s : map.entrySet()){
            System.out.println(s.getKey() + " " + s.getValue());
        }

         */

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), "windows-1251"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8));
        while(bufferedReader.ready()) {
            bufferedWriter.write(bufferedReader.readLine());
        }

        bufferedReader.close();
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}



