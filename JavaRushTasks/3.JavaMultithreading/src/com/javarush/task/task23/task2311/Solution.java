package com.javarush.task.task23.task2311;

/* 
Повторяем threads
*/

public class Solution  {
    public final String name;
    public final String food;
    public final String sound;
    public static Solution solution;

    public Solution(String name, String food, String sound) {
        this.name = name;
        this.food = food;
        this.sound = sound;
        solution= this;
    }
    


    public void eat() {
        System.out.println(name + ": Mmmmm, " + food);
    }

    public void play() {
        System.out.println(name + ": " + sound + " " + sound);
    }
    

    public void sleep(long milliseconds) {
        System.out.println(name + ": Zzzzzzz..." + (milliseconds / 1000) + " s");
    }

    public void Cheater(long m){
        sleep(m);
    }

    public void live() throws InterruptedException {
        Thread thread = new Thread() {
            // class UNKNOWN implements Runnable{
            public void run() {
                try {
                    someActions();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            private void someActions() throws InterruptedException {
                eat();
                play();
                Cheater(1000L);

            }
        };
        thread.start();
        thread.join();
    }

    public static void main(String[] args) throws InterruptedException {
        new Solution("Amigo", "beef", "knock").live();
    }
}
