package com.javarush.task.task17.task1721;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        Solution solution = new Solution();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();

            //String fileName1 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task17\\task1721\\file1";
            //String fileName2 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task17\\task1721\\file2";

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));

            while (fileReader.ready()){
                allLines.add(fileReader.readLine());
            }

            fileReader = new BufferedReader(new FileReader(fileName2));

            while (fileReader.ready()){
                forRemoveLines.add(fileReader.readLine());
            }

            bufferedReader.close();
            fileReader.close();

        }catch(IOException e){
            e.printStackTrace();
        }

        try {
            solution.joinData();
        }catch (CorruptedDataException e){
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {
        List<String> tempStrings = new ArrayList<>(forRemoveLines);

        for(String stringForRemoveLines : forRemoveLines){
            for(String stringAllLines : allLines){
                if(stringForRemoveLines.equals(stringAllLines)){
                    tempStrings.remove(stringForRemoveLines);
                    break;
                }
            }
        }

        if(tempStrings.size() == 0){
            for(String s : forRemoveLines){
                allLines.remove(s);
            }
        }else{
            Iterator<String> iterator = allLines.iterator();
            while(iterator.hasNext()){
                iterator.next();
                iterator.remove();
            }
            throw new CorruptedDataException();
        }
    }
}
