package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            //String fileName = bufferedReader.readLine();
            bufferedReader.close();
            //test
            String fileName = "D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task19\\task1918\\test.html";
            args = new String[1];
            args[0] = "span";

            String tag = args[0];

            FileReader fileReader = new FileReader(fileName);
            StringBuilder stringBuilder = new StringBuilder();

            while(fileReader.ready()){
                stringBuilder.append((char)fileReader.read());
            }
            fileReader.close();

            String htmlFileData = stringBuilder.toString();

            //Pattern pattern = Pattern.compile(String.format("(<%s>?)(.|\\s)+?(</%s>)+?(</%s>)?", teg, teg, teg));
            //Matcher matcher = pattern.matcher(htmlFileData);


            Pattern patternOpenTag = Pattern.compile("<" + tag);
            Pattern patternCloseTag = Pattern.compile("(</)" + tag);

            Matcher matcherOpen = patternOpenTag.matcher(htmlFileData);
            Matcher matcherClose = patternCloseTag.matcher(htmlFileData);

            Map<Integer, String> map = new TreeMap<>();

            while (matcherOpen.find()){
                //System.out.print(matcherOpen.start() + " ");
                //System.out.println(matcherOpen.group() + " " + matcherOpen.end());
                map.put(matcherOpen.start(), matcherOpen.group());
            }
            while (matcherClose.find()){
                //System.out.print(matcherClose.start() + " ");
                //System.out.println(matcherClose.group() + " " + matcherClose.end());
                map.put(matcherClose.start(), matcherClose.group());
            }

            int countOfOpenTag = 0;
            int countOfCloseTag = 0;

            int start = 0;
            int end = 0;

            for(Map.Entry<Integer, String> m : map.entrySet()){
                System.out.println(m.getKey() + " " + m.getValue());

                if(m.getValue().equals("<" + tag)){
                    countOfOpenTag++;
                }

            }

//            while(matcherOpen.find()){
//                System.out.print(matcherOpen.start());
//                System.out.println(" " + matcherOpen.group() + " " + matcherOpen.end());
//                while(matcherClose.find()){
//                    System.out.print(matcherClose.start());
//                    System.out.println(" " + matcherClose.group() + " " + matcherClose.end());
//
//                }
//            }



            for(int i = 0; i < htmlFileData.toCharArray().length; i++){
                //htmlFileData.toCharArray()[0];
            }



        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
