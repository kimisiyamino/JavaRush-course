package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        //D:\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1825\file.avi.part10
        //D:\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1825\file.avi.part3
        //D:\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1825\file.avi.part1
        //D:\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task18\task1825\file.avi.part967

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            List<String> files = new ArrayList<>();

            while (true) {
                String input = bufferedReader.readLine();
                if(input.equals("end")){break;}
                files.add(input);
            }

//            files.add(new File("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1825\\file.avi.part2"));
//            files.add(new File("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1825\\file.avi.part1"));
//            files.add(new File("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1825\\file.avi.part3"));
//            files.add(new File("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1825\\file.avi.part10"));
//            files.add(new File("D:\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1825\\file.avi.part967"));

            files.sort(((o1, o2) -> {
                Integer numOfPart1 = Integer.parseInt(o1.split("\\.part")[1]);
                Integer numOfPart2 = Integer.parseInt(o2.split("\\.part")[1]);
                return numOfPart1.compareTo(numOfPart2);
            }));

            String resultFileName = files.get(0).substring(0, files.get(0).indexOf(".part"));

            BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(resultFileName));
            BufferedInputStream fileReader = null;
            for(String s : files){
                fileReader = new BufferedInputStream(new FileInputStream(s));
                while(fileReader.available() > 0){
                    byte[] buffer = new byte[fileReader.available()];
                    fileReader.read(buffer);
                    fileWriter.write(buffer);
                }
                fileReader.close();
            }


            bufferedReader.close();
            fileWriter.flush();
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
