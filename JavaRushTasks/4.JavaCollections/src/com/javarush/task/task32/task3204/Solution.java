package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 8; i++) {
            stringBuilder.append(s.charAt(new Random().nextInt(s.length())));
        }
        char[] pass = stringBuilder.toString().toCharArray();

        char small = s.charAt(new Random().nextInt(26));
        char big = s.charAt(new Random().nextInt(26) + 26);
        char num = s.charAt(new Random().nextInt(10) + 52);

        char[] smallbignum = {small, big, num};
        int[] indexs = new int[3];

        Set<Integer> _indexs = new HashSet<>();
        while(_indexs.size() != 3){
            _indexs.add(new Random().nextInt(pass.length));
        }
        int iterator = 0;
        for(Integer index : _indexs){
            indexs[iterator] = index;
            iterator++;
        }
        for (int i = 0; i < 3; i++) {
            pass[indexs[i]] = smallbignum[i];
        }

        String password = new String(pass);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            byteArrayOutputStream.write(password.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream;
    }
}
