package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) throws InterruptedException {
        StringBuilder stringBuilder = null;
        for(String word : words) {

            int wordLength = word.length();

            for (int row = 0; row < crossword.length; row++) {
                for (int column = 0; column < crossword[row].length; column++) {

                    // ->
                    if(column + wordLength < crossword[row].length) {
                        stringBuilder = new StringBuilder();
                        for (int i = column; i < column + wordLength; i++) {
                            stringBuilder.append((char) crossword[row][i]);
                        }
                        System.out.print(stringBuilder.toString() + " ");
                        //checkWord(word, stringBuilder.toString());
                    }
                    System.out.println();

                    // <-
                    if(column - (wordLength-1) >= 0) {
                        stringBuilder = new StringBuilder();
                        for (int i = column; i > column - wordLength; i--) {
                            stringBuilder.append((char) crossword[row][i]);
                        }
                        //checkWord(word, stringBuilder.toString());
                        System.out.print(stringBuilder.toString() + " ");
                    }
                    System.out.println();

                    // V || ^
                    if(row >= 0) {
                        stringBuilder = new StringBuilder();
                        for (int i = column; i > column - wordLength; i--) {
                            stringBuilder.append((char) crossword[row][i]);
                        }
                        //checkWord(word, stringBuilder.toString());
                        System.out.println(stringBuilder.toString());
                    }

                }
                System.out.println();
            }

        }
        return null;
    }

    public static boolean checkWord(String word, String comb){
        return false;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
