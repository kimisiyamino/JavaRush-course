package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args)  {
        String input = readStream();
        int[] array = stringToIntArray(input);
        array = getEvenNums(array);
        sort(array);
        printArray(array);
    }

    public static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && temp < arr[j]){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public static void printArray(int[] array){
        for(int i : array) {
            System.out.println(i);
        }
    }

    public static String readStream(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int _byte = 0;
        String string = "";

        try {
            //String input = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task13\\task1326\\file";
            String input = bufferedReader.readLine();
            FileInputStream fileInputStream = new FileInputStream(input);

            while((_byte = fileInputStream.read()) != -1){
                char c = (char)_byte;
                string+=c;
            }
            fileInputStream.close();

        }catch(IOException e){
            System.out.println(e.toString());
        }

        return string;
    }

    private static int[] stringToIntArray(String string) {
        String[] numString;

        if(string.contains(" "))
            numString = string.split(" ");
        else numString = string.split("\n");

        System.lineSeparator();

        int[] numInt = new int[numString.length];

        for(int i = 0 ; i < numString.length; i++) {
            numInt[i] = Integer.parseInt(numString[i]);
        }

        return numInt;
    }

    public static int[] getEvenNums(int[] array){
        int count = 0;
        int[] evenNums = new int[100];

        for(int i = 0 ; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenNums[count++] = array[i];
            }
        }
        int[] evenNumsClear = new int[count];
        System.arraycopy(evenNums, 0, evenNumsClear, 0, evenNumsClear.length);

        return evenNumsClear;
    }
}
