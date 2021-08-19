package com.javarush.task.task18.task1806;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileInputPath1 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1806\\file001";
        String fileOutputPath1 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1806\\file002";

        String fileInputPath2 = "c:/data.txt";
        String fileOutputPath2 = "c:/result.txt";

        FileInputStream inputStream = new FileInputStream(fileInputPath2);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(fileOutputPath2);

        if (inputStream.available() > 0) {
            //читаем весь файл одним куском
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }

        //inputStream.reset();
        //outputStream.flush();

        inputStream.close();
        outputStream.close();

    }
}
