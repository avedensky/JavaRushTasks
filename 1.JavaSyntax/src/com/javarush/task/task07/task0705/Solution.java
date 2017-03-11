package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] vect = new int[20];
        Scanner sc = new Scanner(System.in);

        for (int i=0;i<vect.length;i++) {
            vect[i] = Integer.parseInt(sc.nextLine());
        }

        int[] vect1 = new int[10];
        int[] vect2 = new int[10];

        for (int i=0;i<vect1.length;i++) {
            vect1[i] = vect [i];
        }

        for (int i=0;i<vect2.length;i++) {
            vect2[i] = vect [i+10];
        }

        for (int i=0;i<vect2.length;i++) {
            System.out.println(vect2[i]);
        }

    }
}
