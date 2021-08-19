package com.javarush.task.task16.task1616;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;
       // long time;

        public void run() {
            try {
               // time = System.currentTimeMillis();
                while(true){
                    if(Thread.currentThread().isInterrupted()){
                        throw new InterruptedException();
                    }
                    Thread.sleep(1000);
                    seconds++;

                }

            } catch (InterruptedException e) {
                //seconds = (int)(System.currentTimeMillis() - time)/1000;
                System.out.println(seconds);
            }
        }
    }
}
