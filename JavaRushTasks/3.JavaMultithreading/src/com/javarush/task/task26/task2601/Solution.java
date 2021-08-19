package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Comparator;

/* 
Почитать в инете про медиану выборки
*/

public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17};
        System.out.println(Arrays.toString(sort(array)));

    }

    public static Integer[] sort(Integer[] array) {
        Integer[] array1 = (Integer[])Arrays.stream(array).sorted().toArray(Integer[]::new);

        // 1, 2, 3;    l =3 / 2 +1
        // 1, 2, 3, 4; l= 4 / 2   x1=2, x2=x1+1; x1+x2
        // 1

        int mediana;
        if(array.length % 2 == 1){
            mediana = array1[array1.length/2];
        }else {
            mediana = (array1[array1.length/2]+array1[array1.length/2-1])/2;
        }


        return array1;
    }
}
