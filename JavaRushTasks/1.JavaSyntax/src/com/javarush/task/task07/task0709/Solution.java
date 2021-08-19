package com.javarush.task.task07.task0709;

/* 
Выражаемся покороче
*/

import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<Integer> lengthList = new ArrayList<Integer>();
        ArrayList<Integer> indOfLeast = new ArrayList<Integer>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < 5; i++){
            String s = bufferedReader.readLine();
            list.add(s);
            lengthList.add(s.length());
        }

        int least = lengthList.get(0);
        int count = 1;
        indOfLeast.add(0);

        for(int i = 0; i < lengthList.size() - 1; i++){
            if(lengthList.get(i+1) < least){
                least = lengthList.get(i+1);
                count = 1;
                indOfLeast.clear();
                indOfLeast.add(i+1);
            }else if(lengthList.get(i+1) == least) {
                count++;
                indOfLeast.add(i+1);
            }else{
                continue;
            }
        }

        for(int i = 0; i < count; i++){
            System.out.println(list.get(indOfLeast.get(i)));
        }
    }
}
