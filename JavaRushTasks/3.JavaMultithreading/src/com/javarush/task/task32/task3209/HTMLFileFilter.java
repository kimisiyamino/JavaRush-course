package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        if(f.isDirectory()) return true;

        String extension = getFileExtension(f.getName().toLowerCase());

        if(extension == null) return false;

        return extension.equals(".html") || extension.equals(".htm");
    }

    private static String getFileExtension(String mystr) {
        int index = mystr.indexOf('.');
        return index == -1? null : mystr.substring(index);
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
