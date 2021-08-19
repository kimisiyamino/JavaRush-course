package com.javarush.task.task19.task1923;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Слова с цифрами
*/

public class Solution {
    public static void main(String[] args) {
        String inputFileName = args[0];
        String outputFileName = args[1];

        //String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\file";
        //String fileName2 = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1923\\file2";
        try {

            BufferedReader fileReader = new BufferedReader(new FileReader(inputFileName));
            FileWriter fileWriter = new FileWriter(outputFileName);

            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<String> Words = new ArrayList<>();

            while (fileReader.ready()){
                String input = fileReader.readLine();
                String[] words = input.split(" ");
                Words.addAll(Arrays.asList(words));
            }

            for (String word : Words) {
                boolean haveSmallLetter = false;
                boolean haveBigLetter = false;

                for(int j = 65; j <= 90; j++){
                    char c = (char)j;
                    String letter = Character.toString(c);
                    if(word.contains(letter)){
                        haveBigLetter = true;
                        break;
                    }
                }

                if(!haveBigLetter) {
                    for (int j = 97; j <= 122; j++) {
                        char c = (char) j;
                        String letter = Character.toString(c);
                        if (word.contains(letter)) {
                            haveSmallLetter = true;
                            break;
                        }
                    }
                }


                    for (int j = 48; j <= 57; j++) {
                        char c = (char) j;
                        String letter = Character.toString(c);
                        if (word.contains(letter)) {
                            fileWriter.write(word + " ");
                            break;
                        }
                    }

            }

            fileReader.close();
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
