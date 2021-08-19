package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Solution {
    public static void main(String[] args) {
        if(args[0].equals("-e")){
            encryption(args[1], args[2]);
        }else if(args[0].equals("-d")){
            decryption(args[1], args[2]);
        }

        //encryption("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1826\\file01", "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1826\\file01Cryp");
        //decryption("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1826\\file01Cryp", "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1826\\file01DeCryp");
    }

    public static void encryption(String fileName, String fileOutputName){
        cryp(fileName, fileOutputName);
    }

    public static void decryption(String fileName, String fileOutputName){
        cryp(fileName, fileOutputName);
    }

    public static void cryp(String fileName, String fileOutputName){
        int key = 55;

        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(fileOutputName);

            while(fileInputStream.available() > 0){
                fileOutputStream.write(fileInputStream.read()^key);

            }

            fileInputStream.close();
            fileOutputStream.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
