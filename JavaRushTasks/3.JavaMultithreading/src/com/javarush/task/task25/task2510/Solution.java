package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/

import java.io.IOException;

public class Solution extends Thread {

    public Solution() {
        setDefaultUncaughtExceptionHandler((t, e) -> {
            if(e instanceof Error){
                System.out.println("Нельзя дальше работать");
            }else if(e instanceof Exception){
                System.out.println("Надо обработать");
            }else{
                System.out.println("Поживем - увидим");
            }
        });
    }

    public static void main(String[] args){
    }
}
