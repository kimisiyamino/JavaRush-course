package com.javarush.task.task21.task2113;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Hippodrome {
    
    private List<Horse> horses;
    public static Hippodrome game;
    
    public Hippodrome(List<Horse> horses){
        this.horses = horses;
    }
    
    public static void main(String[] args){
        List<Horse> horses = new ArrayList<>();
        
        Horse horseMike = new Horse("Mike", 3.0f, 0.0f);
        Horse horseJohn = new Horse("John", 3.0f, 0.0f);
        Horse horseKate = new Horse("Kate", 3.0f, 0.0f);
        
        horses.add(horseMike);
        horses.add(horseJohn);
        horses.add(horseKate);
        
        Hippodrome hippodrome = new Hippodrome(horses);
        game = hippodrome;
        
        game.run();
        game.printWinner();
    }
    
    public List<Horse> getHorses(){
        return horses;
    }
    
    public void run(){
        for(int i = 0; i < 100; i++){
            move();
            print();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    public void move(){
        for(Horse h : horses){
            h.move();
        }
    }
    
    public void print(){
        for(Horse h : horses){
            h.print();
        }
        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }

    public Horse getWinner(){
        List<Horse> horse = getHorses();
        horse.sort(new Comparator<Horse>() {
            @Override
            public int compare(Horse o1, Horse o2) {
                if(o1.getDistance() < o2.getDistance()){
                    return -1;
                }else if(o1.getDistance() > o2.getDistance()){
                    return 1;
                }
                return 0;
            }
        });

        return horse.get(horse.size() - 1);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() +"!");
    }
}