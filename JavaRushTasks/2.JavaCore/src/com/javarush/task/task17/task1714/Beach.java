package com.javarush.task.task17.task1714;

/* 
Comparable
*/

public class Beach implements Comparable<Beach>{
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }
    @Override
    public synchronized int compareTo(Beach beath){

            int cmr = 0;

            if(this.distance > beath.distance){
                cmr+=-1;
            }else if(this.distance == beath.distance){
                cmr+=0;
            }else{
                cmr+=1;
            }

            if(this.quality > beath.quality){
                cmr+=1;
            }else if(this.quality == beath.quality){
                cmr+=0;
            }else{
                cmr+=-1;
            }

            return cmr;

    }


    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args) {

    }

}
