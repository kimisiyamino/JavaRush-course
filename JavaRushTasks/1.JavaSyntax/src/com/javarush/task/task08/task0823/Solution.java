package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        char[] charArray = string.toCharArray();
        
        boolean isUpper = false;
        
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == 32){
                isUpper = false;
            }else if(charArray[i] != 32 && !isUpper){
                isUpper = true;
                charArray[i] = swapFirstLetter(charArray[i]);
            }else if(charArray[i] != 32 && isUpper){
            }
        }
        
        for(int i = 0; i < charArray.length; i++)
            System.out.print(charArray[i]);
        
    }
    
    public static char swapFirstLetter(char c){
        return c = Character.toUpperCase(c);
    }
    
}
