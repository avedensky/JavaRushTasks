package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int[] vect = new int[3];
        int[] vect2 = new int[3];


        for (int i=0;i<3;i++) {
            vect[i] = sc.nextInt();
        }

        int k = 0;
        int k1 = 0;
        int res = 0;
        for (int i=0;i<3;i++) {
            k = 0;
            for (int j = 0; j < 3; j++)
                if (vect[i] != vect[j]) {
                    k += 1;
                }
            if (k == 2) {
                res = i;
                k1 += 1;

            }
        }
        if (k1 == 1)
            System.out.println(res+1);
    }
}
