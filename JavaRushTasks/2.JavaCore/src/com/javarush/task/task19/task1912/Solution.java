package com.javarush.task.task19.task1912;



import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*
Ридер обертка 2
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream standard = System.out;
        ByteArrayOutputStream bbbb = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bbbb));
        testString.printSomething();
        System.setOut(standard);
        System.out.println(bbbb.toString().replaceAll("te", "??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
