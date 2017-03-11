package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код


        int[] vect = new int[10];

        Scanner sc = new Scanner(System.in);

        for (int i=0;i<vect.length; i++) {
            vect[i] = Integer.parseInt(sc.nextLine());
        }

        int tmp = 0;
        int i = 0;
        int j = vect.length-1;
        while (i!=j+1) {
            tmp = vect[i];
            vect[i] = vect [j];
            vect [j] = tmp;
            i++;
            j--;
        }

        for (int k = 0;k<vect.length; k++) {
            System.out.println(vect[k]);

        }
    }
}

