package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties properties = new Properties();
        Set<Map.Entry<String, String>> entry = runtimeStorage.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, String> m = iterator.next();
            properties.setProperty(m.getKey(), m.getValue());
        }
        properties.store(outputStream, null);

    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties properties = new Properties();
        properties.load(inputStream);
        Set<String> propertiesKeys = properties.stringPropertyNames();

        for(String key : propertiesKeys){
            runtimeStorage.put(key, properties.getProperty(key));
        }

    }
// D:\JavaRush\JavaRushTasks\2.JavaCore\src\com\javarush\task\task20\task2003\file.properties
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
