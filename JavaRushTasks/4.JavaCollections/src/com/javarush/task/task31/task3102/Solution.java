package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/* 
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        Queue<File> queue = new LinkedList<>();
        queue.add(new File(root));
        List<String> list = new LinkedList<>();

        while (!queue.isEmpty()) {
            for (File temp : Objects.requireNonNull(queue.poll().listFiles())) {
                if (temp.isFile()) {
                    list.add(temp.getAbsolutePath());
                } else if (temp.isDirectory()) {
                    queue.add(temp);
                }
            }
        }

        return list;

    }

    public static void main(String[] args) {

    }
}
