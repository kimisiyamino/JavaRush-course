package com.javarush.task.task25.task2502;

import java.lang.reflect.Array;
import java.util.*;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum
    Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            //init wheels here
            wheels = new ArrayList<>();

            if(loadWheelNamesFromDB().length < 4 || loadWheelNamesFromDB().length > 4){
                throw new Exception();
            }

            List<String> currentWheels = new ArrayList<>();
            for(Wheel w : Wheel.values()){
                currentWheels.add(w.toString());
            }

            for(String wheel : loadWheelNamesFromDB()){
                if(currentWheels.contains(wheel)){
                    currentWheels.remove(wheel);
                    wheels.add(Wheel.valueOf(wheel));
                }else{
                    throw new Exception();
                }
            }

            // не подходящее колесо
            // 2-3-4 одинаковых колеса
            // более 4 колёс
            // менее 4 колёс

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
         Car car = new Car();
    }
}
