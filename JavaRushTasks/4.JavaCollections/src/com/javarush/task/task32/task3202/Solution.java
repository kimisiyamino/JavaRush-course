package com.javarush.task.task32.task3202;

import java.io.*;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    public static StringWriter getAllDataFromInputStream(InputStream is){
        try {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);

            char[] chars = new char[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                chars[i] = (char) bytes[i];
            }

            StringWriter stringWriter = new StringWriter();
            stringWriter.write(chars);
            return stringWriter;
        }catch (Exception e){
            return new StringWriter();
        }
    }
}
