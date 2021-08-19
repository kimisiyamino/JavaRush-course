package com.javarush.task.task18.task1812;

/* 
Расширяем AmigoOutputStream
*/

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class QuestionFileOutputStream implements AmigoOutputStream {
    AmigoOutputStream amigoOutputStream;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream){
        this.amigoOutputStream = amigoOutputStream;
    }

    public void flush() throws IOException {
        amigoOutputStream.flush();
    }

    public void write(int b) throws IOException {
        amigoOutputStream.write(b);
    }

    public void write(byte[] b) throws IOException{
        amigoOutputStream.write(b);
    }

    public void write(byte[] b, int off, int len) throws IOException{
        amigoOutputStream.write(b, off, len);
    }

    public void close() throws IOException{
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");

        String input = new Scanner(System.in).nextLine();
        if(input.equals("Д")){
            amigoOutputStream.close();
        }else{
            return;
        }


    }
}


