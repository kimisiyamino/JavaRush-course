package com.javarush.task.task18.task1816;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) {
        int englishLetterCount = 0;
        try{
            BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
            while(fileReader.ready()){
                int inputByte = fileReader.read();

                if(inputByte >= 97 && inputByte <= 122 || inputByte >= 65 && inputByte <= 90){
                    englishLetterCount++;
                }
            }

            fileReader.close();

        }catch (IOException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(englishLetterCount);
    }
}
