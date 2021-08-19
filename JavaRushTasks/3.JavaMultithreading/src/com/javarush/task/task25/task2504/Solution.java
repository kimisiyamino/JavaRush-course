package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/

import javafx.scene.input.TouchPoint;

import java.lang.Thread.State;

import static java.lang.Thread.State.NEW;

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод

        for (Thread thread : threads){
            State state = thread.getState();
            switch (state){
                case NEW:
                    thread.start();
                    break;
                case WAITING:
                case BLOCKED:
                case TIMED_WAITING:
                    thread.interrupt();
                    break;
                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }

        }
    }

    public static void main(String[] args) {
    }
}
