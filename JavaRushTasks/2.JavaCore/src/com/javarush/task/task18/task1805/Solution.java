package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        //String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1805\\file";
        FileInputStream fileReader = new FileInputStream(fileName);
        TreeSet<Integer> treeSet = new TreeSet<>();
        
        while(fileReader.available() > 0){
              treeSet.add(fileReader.read());
        }

        Iterator<Integer> it = treeSet.iterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }

        bufferedReader.close();
        fileReader.close();
    }
}
