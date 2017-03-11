package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        if (a > 0) {
            a = a * 2;
            System.out.println(a);
            return;
        }
        if (a<0) {
            a += 1;
            System.out.println(a);
            return;
        }
        if (a==0) {
            a = 0;
            System.out.println(a);
            return;
        }
    }

}