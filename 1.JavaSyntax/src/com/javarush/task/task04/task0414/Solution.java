package com.javarush.task.task04.task0414;

/* 
Количество дней в году
*/

import java.io.*;

public class Solution {
    public static int daysInTheYear (int a) {
        int a_r400 = a % 400;
        int a_r100 = a % 100;
        int a_r4 = a % 4;
        int res = 365;

        if (a_r4 == 0) {
            res = 366;
        }

        if (a_r100 == 0 && a_r400 != 0) {
            res = 365;
        }

        return res;
    }

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());

        System.out.println("количество дней в году: "+daysInTheYear (a));
    }
}