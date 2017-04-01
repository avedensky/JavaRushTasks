package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд

1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
2. Метод detectAllWords должен найти все слова из words в массиве crossword.
3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) — последней.
text — это само слово, располагается между начальным и конечным элементами
4. Все слова есть в массиве.
5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
6. Метод main не участвует в тестировании.


Требования:
1. В классе Solution должен существовать метод detectAllWords.
2. В классе Solution должен существовать класс Word.
3. Метод detectAllWords должен быть статическим.
4. Метод detectAllWords должен быть публичным.
5. Метод detectAllWords должен возвращать список всех слов в кроссворде (согласно условию задачи).
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        detectAllWords(crossword, "home", "same");
        //detectAllWords(crossword, "leo","rre");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }


    public static Word checkNE(int[][] crossword, int startX, int startY, String s) {
        int x = startX - 1;
        int y = startY - 1;
        for (int i = 1; i < s.length(); i++) {
            if (x < 0 || y < 0)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x--;
            y--;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x + 1, y + 1);
        return w;
    }

    public static Word checkN(int[][] crossword, int startX, int startY, String s) {
        int x = startX;
        int y = startY - 1;
        for (int i = 1; i < s.length(); i++) {
            if (y < 0)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            y--;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x, y + 1);
        return w;
    }

    public static Word checkNW(int[][] crossword, int startX, int startY, String s) {
        int x = startX + 1;
        int y = startY - 1;
        for (int i = 1; i < s.length(); i++) {
            if (x >= crossword[0].length || y < 0)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x++;
            y--;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x - 1, y + 1);
        return w;
    }


    public static Word checkE(int[][] crossword, int startX, int startY, String s) {
        int x = startX + 1;
        int y = startY;
        for (int i = 1; i < s.length(); i++) {
            if (x >= crossword[0].length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x++;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x - 1, y);
        return w;
    }

    public static Word checkSE(int[][] crossword, int startX, int startY, String s) {
        int x = startX + 1;
        int y = startY + 1;
        for (int i = 1; i < s.length(); i++) {
            if (x >= crossword[0].length || y >= crossword.length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x++;
            y++;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x - 1, y - 1);
        return w;
    }


    public static Word checkS(int[][] crossword, int startX, int startY, String s) {
        int x = startX;
        int y = startY + 1;
        for (int i = 1; i < s.length(); i++) {
            if (y >= crossword.length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            y++;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x, y - 1);
        return w;
    }

    public static Word checkSW(int[][] crossword, int startX, int startY, String s) {
        int x = startX - 1;
        int y = startY + 1;
        for (int i = 1; i < s.length(); i++) {
            if (x < 0 || y >= crossword.length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x--;
            y++;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x + 1, y - 1);
        return w;
    }

    public static Word checkW(int[][] crossword, int startX, int startY, String s) {
        int x = startX - 1;
        int y = startY;
        for (int i = 1; i < s.length(); i++) {
            if (x < 0 || y >= crossword[0].length)
                return null;

            if ((char) crossword[y][x] != s.charAt(i))
                return null;
            x--;
        }
        Word w = new Word(s);
        w.setStartPoint(startX, startY);
        w.setEndPoint(x + 1, y);
        return w;
    }


    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> resWords = new ArrayList<>();

        for (String word : words) {
            char latter = word.charAt(0);

            //Search first latter in the crossword
            for (int i = 0; i < crossword.length; i++) {
                for (int j = 0; j < crossword[i].length; j++) {

                    if ((char) crossword[i][j] == latter) { //ok, first latter from word has been finded.
                        int startX = j;
                        int startY = i;

                        Word[] vector = new Word[8];

                        vector[0] = checkNE(crossword, startX, startY, word);
                        vector[1] = checkN(crossword, startX, startY, word);
                        vector[2] = checkNW(crossword, startX, startY, word);
                        vector[3] = checkE(crossword, startX, startY, word);
                        vector[4] = checkSE(crossword, startX, startY, word);
                        vector[5] = checkS(crossword, startX, startY, word);
                        vector[6] = checkSW(crossword, startX, startY, word);
                        vector[7] = checkW(crossword, startX, startY, word);

                        for (int ii = 0; ii < vector.length; ii++)
                            if (vector[ii] != null)
                                resWords.add(vector[ii]);
                    }
                }
            }
        }
        return resWords;
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

