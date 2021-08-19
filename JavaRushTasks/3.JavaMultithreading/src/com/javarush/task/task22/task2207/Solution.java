package com.javarush.task.task22.task2207;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String fileName = bufferedReader.readLine(); // Для отправки на проверку, так же поменять аргумент FileReader на fileName
            try (FileReader fileReader = new FileReader(fileName)){
                int c;
                while((c = fileReader.read()) != -1){
                    if(c != '\r')
                        stringBuilder.append((char)c);
                }
            }catch(FileNotFoundException e) {
                e.printStackTrace();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        String[] words = stringBuilder.toString().split("[ \n]");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(words));

//        for(int x = 1; x < words.length; x++) {
//            if (words[x - 1].length() == words[x].length()) {
//                if (equalsRotate(words[x - 1], words[x])) {
//                    Pair pair = new Pair();
//                    pair.first = words[x - 1];
//                    pair.second = words[x];
//                    result.add(pair);
//                    //x++; // Нужно, если повторяем используемые слова
//                }
//            }
//        }
        int i = 0;
        for(; i < words.length; i++){
            for (int j = i + 1; j < words.length; j++){
                if(equalsRotate(words[i], words[j])){
                    Pair pair = new Pair();
                    pair.first = words[i];
                    pair.second = words[j];
                    result.add(pair);
                    wordsList.remove(j);
                    wordsList.remove(i);
                    words = new String[wordsList.size()];

                    for (int k = 0; k < words.length; k++){
                        words[k] = wordsList.get(k);
                    }
                    i = -1;
                    break;
                }
            }
        }

       // System.out.println(wordsList);
       // System.out.println(Arrays.toString(words));
       // System.out.println(result);
        for(Pair p : result) {
            System.out.println(p.first + " " + p.second);
        }
    }

    public static boolean equalsRotate(String s1, String s2){
        if(s1.length() != s2.length()) return false;

        for(int i = 0, j = s1.length()-1; i < s1.length(); i++, j--){
            if(s1.charAt(i) != s2.charAt(j)) return false;
        }
        return true;
    }

    public static class Pair {
        String first;
        String second;

        public Pair(){

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
