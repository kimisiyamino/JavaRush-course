package com.javarush.task.task27.task2711;

import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch
*/

public class Solution {
    //private final Object lock = new Object();
    //private volatile boolean isWaitingForValue = true;

    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() throws InterruptedException {
        /*System.out.println(Thread.currentThread().getName() + " synchronized");
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " while");
            while (isWaitingForValue) {
                System.out.println(Thread.currentThread().getName() + " wait()");
                lock.wait();
            }
            System.out.println(Thread.currentThread().getName() + " retrieveValue()()");
            retrieveValue();
            System.out.println(Thread.currentThread().getName() + " isWaitingForValue()()");
            isWaitingForValue = false;
            System.out.println(Thread.currentThread().getName() + " notify()()");
            lock.notify();
        }*/

        System.out.println(Thread.currentThread().getName() + " await()");
        latch.await();
        System.out.println(Thread.currentThread().getName() + " retrieveValue()");
        retrieveValue();
        System.out.println(Thread.currentThread().getName() + " countDown()");
        latch.countDown();
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) {
        
        Solution solution = new Solution();
        
        Thread thread228 = new Thread(() -> {
            try{
                solution.someMethod();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread threadGolum = new Thread(() -> {
            try{
                solution.someMethod();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread threadSanya = new Thread(() -> {
            try{
                solution.someMethod();
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });
        
        thread228.start();
        threadGolum.start();
        threadSanya.start();

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        solution.latch.countDown();
        System.out.println(Thread.currentThread().getName() + " exit");
    }
}
