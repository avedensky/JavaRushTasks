package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList <Character> vowels = new ArrayList<>();
        ArrayList <Character> consonants = new ArrayList<>();
        String s = br.readLine();

        Character ch;
        for (int i=0;i<s.length();i++) {
            ch = s.charAt(i);
            if (ch == ' ')
                continue;
            if (isVowel(ch) == true)
                vowels.add(ch);
            else
                consonants.add(ch);
        }


        for (Character ch1: vowels)
            System.out.print(ch1+" ");
        System.out.println();
        for (Character ch1: consonants)
            System.out.print(ch1+" ");
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}