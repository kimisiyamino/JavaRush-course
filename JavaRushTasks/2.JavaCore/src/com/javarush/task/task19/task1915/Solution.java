package com.javarush.task.task19.task1915;

import java.io.*;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        try{
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            PrintStream standardOutStream = System.out;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream myPrintStream = new PrintStream(byteArrayOutputStream);
            System.setOut(myPrintStream);

            testString.printSomething();
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            System.setOut(standardOutStream);
            System.out.println(byteArrayOutputStream.toString());
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedReader.close();
        }catch(IOException e){
            e.printStackTrace();
        }



    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}






