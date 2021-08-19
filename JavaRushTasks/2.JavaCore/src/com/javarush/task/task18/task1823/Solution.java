package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> files = new ArrayList<>();
        while(true){
            try {
                String input = bufferedReader.readLine();
                if(input.equals("exit")){
                    bufferedReader.close();
                    break;
                }
                files.add(input);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        for(String file : files) {
            ReadThread readThread = new ReadThread(file);
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        List<Byte> bytes;
        FileInputStream fileInputStream;

        public ReadThread(String fileName) {
            this.fileName = fileName;
            try {
                fileInputStream = new FileInputStream(fileName);
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }
            bytes = new ArrayList<>();
            start();
        }

        @Override
        public void run(){
            try {
                while (fileInputStream.available() > 0) {
                    bytes.add((byte)fileInputStream.read());
                }
                fileInputStream.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            Set<Byte> bytes0 = new TreeSet<>(bytes);
            Iterator<Byte> iterator = bytes0.iterator();

            byte tempByte = 0;
            int freq;
            int maxFreq = 0;

            while(iterator.hasNext()){
                byte b = iterator.next();
                freq = Collections.frequency(bytes, b);
                if(maxFreq < freq) {
                    maxFreq = freq;
                    tempByte = b;
                }
            }

            resultMap.put(fileName, (int)tempByte);


        }
    }
}
