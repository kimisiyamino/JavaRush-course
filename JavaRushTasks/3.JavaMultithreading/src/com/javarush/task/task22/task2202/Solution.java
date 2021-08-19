package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString("Java Rush - лучший - сервис - обучения Java."));
        System.out.println(getPartOfString("w x y e c."));

        //System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        if(string == null){ throw new TooShortStringException(); }
        if(string.length() == 0){ throw new TooShortStringException(); }
        if(getSpaceValue(string) < 4){ throw new TooShortStringException(); }
            
        int spaceCount = 0;
        int first = 0;
        char[] stringArray = string.toCharArray();
            
        for(int i = 0; i < stringArray.length; i++){
            if(stringArray[i] == ' '){
                spaceCount++;
                if(spaceCount == 1){
                    first = i;
                }
                if(spaceCount == 4){
                    if(i != stringArray.length-1){
                        string = string.substring(first + 1, getFinish(i+1, stringArray)+1);
                        break;
                    }
                }
            }
        }
        return string;
    }
    
    public static int getFinish(int i, char[] stringArray){
//        while(stringArray[i] != ' ' || stringArray[i] != '\n' {
//            if(i != stringArray.length - 1){
//                i++;
//            }else if(i == stringArray.length - 1){
//                break;
//            }
//        }

        int x;
        for(x = i; x < stringArray.length; x++){
            if(stringArray[x] == ' '){
                return x-1;
            }else if (stringArray[x] == '\n'){
                return x-1;
            }else if (x == stringArray.length-1) {
                return x;
            }
        }
        return x;
    }
    
    public static int getSpaceValue(String string){
        int count = 0;
        for(char c : string.toCharArray()){
            if(c == ' '){
                count++;
            }
        }
        return count;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
