package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] vect = new int [3];

        vect[0] = Integer.parseInt(br.readLine());
        vect[1] = Integer.parseInt(br.readLine());
        vect[2] = Integer.parseInt(br.readLine());

        int k;
        for (int i=0;i<vect.length;i++) {
            for (int j=i; j<vect.length;j++) {
                if (vect[j]>vect[i]) {
                    k = vect[i];
                    vect[i] = vect[j];
                    vect[j] = k;
                }
            }
        }

        for (int i=0;i<vect.length;i++) {
            System.out.print(vect[i]+" ");
        }
    }
}
