package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        ArrayList<Long> arrayList = new ArrayList<>();
        long[] result = null;

        for(long i = 0; i < N; i++){
            long sum = 0;

            for(int c = 0; c < getNumLength(i); c++) {
                int x = (Long.toString(i).charAt(c));
                x-='0';
                sum+=(long)Math.pow(x, getNumLength(i));
            }

            if(sum == i){
                arrayList.add(sum);
            }
        }
        result = new long[arrayList.size()];

        for(int i = 0; i < arrayList.size(); i++){
            result[i] = arrayList.get(i);
        }

        return result;
    }

    public static int getNumLength(long num){
        return Long.toString(num).length();
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
