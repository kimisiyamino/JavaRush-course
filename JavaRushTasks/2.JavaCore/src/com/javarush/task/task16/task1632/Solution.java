package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static{
        Thread thread01 = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){}
            }
        });
        Thread thread02 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    Thread.sleep(0);
                }catch(InterruptedException e){
                    System.out.println("InterruptedException");
                }
            }
        });
        Thread thread03 = new Thread(new Runnable(){
            @Override
            public void run(){
                try{
                    Thread.sleep(500);
                    System.out.println("Ура");
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        Thread thread044 = new Thread(new thread04());
        
        Thread thread05 = new Thread(new Runnable(){
            @Override
            public void run(){
                while(true){}
            }
        });
        
        
        threads.add(thread01);
        threads.add(thread02);
        threads.add(thread03);
        threads.add(thread044);
        threads.add(thread05);
    }
    
    public static void main(String[] args) {
    }
 
}
    class thread04 implements Message, Runnable{
        volatile boolean runn = true;
        public void showWarning(){
            runn = false;
        }
        public void run(){
            while(runn){
                
            }
        }
    }