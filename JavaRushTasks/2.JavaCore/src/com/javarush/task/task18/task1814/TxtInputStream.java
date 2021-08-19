package com.javarush.task.task18.task1814;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.*;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String fileName) throws UnsupportedFileNameException, IOException{
        super(fileName);

        Matcher m = Pattern.compile("\\.txt$").matcher(fileName);
        if(!m.find()){
            super.close();
            throw new UnsupportedFileNameException();
        }
    }


    public static void main(String[] args) throws UnsupportedFileNameException, IOException {
      
    }


}

