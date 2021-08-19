package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) {
        try {

            //args = new String[3];
            //args[0] = "D:\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task32\\task3201\\file";
            //args[1] = "100";
            //args[2] = "===text===";

            RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");
            if(!(randomAccessFile.length() <= Integer.parseInt(args[1]))) {
                randomAccessFile.seek(Integer.parseInt(args[1]));
            }else{
                randomAccessFile.seek(randomAccessFile.length());
            }
            randomAccessFile.write(args[2].getBytes());
            randomAccessFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
