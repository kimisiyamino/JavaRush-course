package com.javarush.task.task18.task1809;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;

/*
Реверс файла
*/
public class Solution {
    public static void main(String[] args) throws IOException {
            // D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1809\\file01
            // D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1809\\file02
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream readerFile = new FileInputStream(bf.readLine());
            FileOutputStream writerFile = new FileOutputStream(bf.readLine());

            byte[] bytes = new byte[readerFile.available()];

            while(readerFile.available() > 0){
                readerFile.read(bytes);
            }

            for (int i = bytes.length - 1; i >= 0; i--)
                 writerFile.write(bytes[i]);

            /*
            // Решение 2
            ArrayList<Integer> list = new ArrayList<>();
            int t;
            while((t = readerFile.read()) != -1)
                list.add(t);

            Collections.reverse(list);
            for(int x : list){
                writerFile.write(x);
            }*/
            bf.close();
            readerFile.close();
            writerFile.close();
    }
}