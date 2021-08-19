package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Thread.setDefaultUncaughtExceptionHandler;

/* 
Живем своим умом
*/

public class Solution implements Thread.UncaughtExceptionHandler {


    public static void main(String[] args){

    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
            thread.interrupt();
            Throwable tempThrowable = throwable;
            List<String> throwables = new ArrayList<>();
            throwables.add(throwable.toString());

            while (tempThrowable.getCause() != null){
                throwables.add(tempThrowable.getCause().toString());
                tempThrowable = tempThrowable.getCause();
            }

            for(int i = throwables.size()-1; i >= 0; i--){
                System.out.println(throwables.get(i));
            }
    }
}
