package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] strs = new String[10];

        Scanner sc = new Scanner(System.in);

        for (int i= 0 ;i <8;i++) {
            strs[i] = sc.nextLine();
        }

        for (int i = 9 ;i >= 0; i--) {
            System.out.println(strs[i]);
        }
    }
}