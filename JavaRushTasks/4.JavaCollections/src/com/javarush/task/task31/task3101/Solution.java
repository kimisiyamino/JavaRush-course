package com.javarush.task.task31.task3101;

import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        // args[0] : D:\\test
        // args[1] : D:\\test\\file.txt
        //
        // Test
//        args = new String[2];
//        String path = "D:\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3101";
//        String pathAbsolute = "D:\\JavaRush\\JavaRushTasks\\4.JavaCollections\\src\\com\\javarush\\task\\task31\\task3101\\file.txt";
//        args[0] = path;
//        args[1] = pathAbsolute;
        //

        String pathToDirectory = args[0];
        String pathToFile = args[1];

        // Rename
        File resultFileAbsolutePath = new File(pathToFile);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        if(FileUtils.isExist(allFilesContent))
            FileUtils.deleteFile(allFilesContent);

        FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);



        //args[0] = args[0].replaceAll("\\\\", "/");
        //File allFilesContent = new File("allFilesContent");


        //File allFilesContent = new File(pathToDirectory + "\\allFilesContent.txt");
        //System.out.println(FileUtils.isExist(fileResultNewName));

        //File dir = new File(pathToDirectory);
        //System.out.println("fsdf " + fileResultNewName.getName());
        //File ff = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        // Files.walk(Paths.get())
        //List<File> allfiles = new LinkedList<>();
//        List<File> dirs = new LinkedList<>();
//
        //  try {
        //    allfiles = Files.walk(Paths.get(args[0]))
        //           .map(Path::toFile)
        //           .collect(Collectors.toList());
        // } catch (IOException e) {
        //     e.printStackTrace();
        //}
//
        // //System.out.println("ALL: " + allfiles.size());
//
//        for (File file : allfiles) {
//            if (Files.isDirectory(file.toPath())) {
//                dirs.add(file);
//            }
//        }
//        System.out.println("Directories: ");
//        for (File dir_ : dirs) {
//            System.out.println(dir_.getName() + "   " + dir_.getParent());
//        }
//
//
//        for (File dir_ : dirs) {
//            System.out.println("\n=== == Dir: " + dir_.getName() + " " + dir_.getPath());
//            List<File> copy = new LinkedList<>(allfiles);
//            for (File file : copy) {
//                if (file.getParent().equals(dir_.getPath())) {
//
//                    //System.out.println(file.getParent());
//                    //System.out.println(dir_.getParent());
//                    System.out.println(file.getName() + "\t\t\t\t\t\t" + file.length() + "bytes" + "\t\t\t\t\t" + file.getParent());
//                    allfiles.remove(file);
//                }
//            }
//
//        }

        //Task:
        List<File> sortedFiles = new ArrayList<>();

        try {
            sortedFiles = Files.walk(Paths.get(pathToDirectory))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .filter(f -> f.length() <= 50)
                    .filter(f -> f.getName().endsWith(".txt"))
                    .filter(f -> !f.getName().equals("allFilesContent.txt"))
                    .sorted()
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("\n\n\n SortedFiles::: ");
        //sortedFiles.forEach(f -> System.out.println(f.getAbsoluteFile() + " " + f.getName()));


        BufferedReader fileReader = null;
        StringBuilder filesData = new StringBuilder();
        for (File sortedFile : sortedFiles) {
            fileReader = new BufferedReader(new FileReader(sortedFile));
            while (fileReader.ready()){
                String inputLine = fileReader.readLine();
                filesData.append(inputLine).append(System.lineSeparator());
            }
        }
//
//        BufferedWriter writer = new BufferedWriter(new FileWriter(pathToDirectory + "/allFilesContent.txt"));
//        writer.write(filesData.toString());
//        writer.flush();
//        writer.close();

        FileOutputStream fos = new FileOutputStream(allFilesContent);
        fos.write(filesData.toString().getBytes());
        fos.flush();
        fos.close();



        fileReader.close();



        //System.out.println(filesData.toString());


//        tr
//       y {
//            FileInputStream  reader = null;
//            BufferedWriter writer = null;
//            for (File sortedFile : sortedFiles) {
//                reader = new FileInputStream(new File(sortedFile.getParent() + "\\" + sortedFile.getName()));
//                byte[] data = new byte[reader.available()];
//                writer = new BufferedWriter(new FileWriter(allFilesContent));
//                writer.write(reader.read(data));
//                writer.write('\n');
//            }
//            writer.flush();
//            writer.close();
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                System.out.println("Cloase streams");
//                assert writer != null;
//
//            } catch (IOException e) {
//                System.out.println("PIZDA12");
//                e.printStackTrace();
//            }


        //sortedFiles = sortedFiles.stream().filter(f -> Files.isRegularFile(f.toPath()) && f.length() < 50 && f.getName().substring(f.getName().length() - 5, f.getName().length() - 1).equals(".txt")).sorted().collect(Collectors.toList());


        //sortedFiles.stream().forEach( (f) -> System.out.println(f.getName()));
    }
}

