package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String fileNameInput = bufferedReader.readLine();
        //fileNameInput = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1803\\file";

        List<Integer> bytesList = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();

        FileInputStream fileInputStream = new FileInputStream(fileNameInput);
        while(fileInputStream.available() > 0){
            int b = fileInputStream.read();
            bytesList.add(b);
        }

        bufferedReader.close();
        fileInputStream.close();
        //System.out.println("Bytes: " + bytesList.toString());

        while (bytesList.size() > 0){
            int firstElement = bytesList.get(0);
            int count = 0;

            Iterator<Integer> iterator = bytesList.iterator();
            while (iterator.hasNext()){
                int x = iterator.next();
                if(x == firstElement){
                    count++;
                    iterator.remove();
                }
            }
            map.put(firstElement, count);
        }

        //System.out.println(map.toString());

        int max = 0;
        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() > max){
                max = m.getValue();
            }
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()){
            if(m.getValue() == max){
                System.out.print(m.getKey() + " ");
            }
        }


       /* ArrayList<Integer> listcopy1 = new ArrayList<>(list);
        HashSet<Integer> set = new HashSet<>(listcopy1);

        int nums[] = new int[set.size()];
        int counts[] = new int[set.size()];

        int iter = 0;

        while(listcopy1.size() > 0) {

            int n = listcopy1.get(0);
            int count = 0;

            Iterator<Integer> iterator = listcopy1.iterator();
            while (iterator.hasNext()) {
                if(n == iterator.next()){
                    count++;
                    iterator.remove();
                }
            }

            nums[iter] = n;
            counts[iter] = count;
            iter++;
        }

        ArrayList<Integer> numslist = new ArrayList<>();
        ArrayList<Integer> countslist = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numslist.add(nums[i]);
            countslist.add(counts[i]);
        }

        int max = Collections.max(countslist);
        int maxInd = countslist.indexOf(max);
        System.out.println(numslist.get(maxInd));*/
    }
}
