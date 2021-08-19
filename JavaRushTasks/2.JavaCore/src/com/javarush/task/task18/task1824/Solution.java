package com.javarush.task.task18.task1824;

import java.io.*;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String input = "";
        BufferedReader bf = null;
        FileInputStream fis = null;
        while(true){
            try{
                bf = new BufferedReader(new InputStreamReader(System.in));
                input = bf.readLine();
                fis = new FileInputStream(input);
                fis.close();
            }catch(FileNotFoundException e){
                System.out.println(input);
                bf.close();
                break;
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
