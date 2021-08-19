package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/* 
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream standardOut = System.out;

        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream myPrintStream = new PrintStream(outputStream);

        System.setOut(myPrintStream);

        testString.printSomething();

        System.setOut(standardOut);

        String[] data = outputStream.toString().split(" ");
        int a = Integer.parseInt(data[0]);
        int b = Integer.parseInt(data[2]);
        char operator = data[1].charAt(0);
        int c = 0;

        switch (operator){
            case '+': c = a + b; break;
            case '-': c = a - b; break;
            case '*': c = a * b; break;
        }

        System.out.printf("%d %c %d = %d", a, operator, b, c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

