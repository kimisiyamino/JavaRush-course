package com.javarush.task.task09.task0929;

/* 
Обогатим код функциональностью!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //String sourceFileName = reader.readLine();
        //String destinationFileName = reader.readLine(); //"D:\\JavaRush\\JavaRushTasks\\1.JavaSyntax\\src\\com\\javarush\\task\\task09\\task0929\\file02";
        //InputStream fileInputStream = null;

        String sourceFileName = reader.readLine();
        try{
            InputStream fileInputStream = getInputStream(sourceFileName);
        }catch(FileNotFoundException e){
            System.out.println("Файл не существует.");
            sourceFileName = reader.readLine();
        }
        InputStream fileInputStream = getInputStream(sourceFileName);
        String destinationFileName = reader.readLine();
        OutputStream fileOutputStream = getOutputStream(destinationFileName);

            int data = 0;
            while (fileInputStream.available() > 0) {
                data = fileInputStream.read();
                fileOutputStream.write(data);
            }

            fileInputStream.close();
            fileOutputStream.close();
    }

    public static InputStream getInputStream(String fileName) throws IOException {
        return new FileInputStream(fileName);
    }

    public static OutputStream getOutputStream(String fileName) throws IOException {
        return new FileOutputStream(fileName);
    }


}

