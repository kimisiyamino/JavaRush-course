package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/


import java.io.*;


public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader;
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        String fileName1, fileName2;
        double d1, d2;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();

            //fileName1 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1820\\file01";
            //fileName2 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1820\\file02";


            bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName1));

            while (bufferedInputStream.available() > 0) {
                Character c = (char)bufferedInputStream.read();
                stringBuilder.append(c.toString());
            }

            String[] nums = stringBuilder.toString().split(" ");
            double[] doublenums = new double[nums.length];
            int i = 0;
            for(String s : nums){
                doublenums[i++] = Double.parseDouble(s);
            }

            int[] intnums = new int[doublenums.length];

            for (int j = 0; j < doublenums.length; j++) {
                intnums[j] = (int)Math.round(doublenums[j]);
            }

            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName2));

            stringBuilder = new StringBuilder();
            for (int j = 0; j < intnums.length; j++) {

                stringBuilder.append(intnums[j] + " ");

            }

            String h = stringBuilder.toString();
            byte[] bytesOutput = h.getBytes();

            bufferedOutputStream.write(bytesOutput, 0, bytesOutput.length);

            bufferedInputStream.close();
            bufferedReader.close();
            bufferedOutputStream.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
