package com.javarush.task.task19.task1911;

import javax.sound.midi.Soundbank;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/* 
Ридер обертка
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws FileNotFoundException {
        ByteArrayOutputStream array = new ByteArrayOutputStream();
        String string = "";
        PrintStream o = System.out;
        PrintStream output = new PrintStream(array);
        System.setOut(output);
        testString.printSomething();
        System.setOut(o);
        string = array.toString();
        string = string.toUpperCase();
        System.out.println(string);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
