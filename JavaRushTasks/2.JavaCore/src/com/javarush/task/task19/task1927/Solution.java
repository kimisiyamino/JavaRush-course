package com.javarush.task.task19.task1927;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String separator = System.lineSeparator();

        PrintStream standard = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream hackStream = new PrintStream(byteArrayOutputStream);
        System.setOut(hackStream);

        testString.printSomething();
        String data = byteArrayOutputStream.toString();
        String[] lines = data.split(separator);

        String spam = "JavaRush - курсы Java онлайн";
        StringBuilder stringBuilder = new StringBuilder();

        int iteratr = 0;
        for(int i = 0; i < lines.length; i++){
            stringBuilder.append(lines[i]).append(separator);
            iteratr++;
            if(i != lines.length-1 && iteratr == 2){
                stringBuilder.append(spam).append(separator);
                iteratr=0;
            }
        }

        System.setOut(standard);
        System.out.println(stringBuilder.toString());
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
