package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a  = Integer.parseInt(br.readLine());
        int b  = Integer.parseInt(br.readLine());

        if (a>b)
            System.out.println(b);

        if (b>a)
            System.out.println(a);

        if (a==b)
            System.out.println(a);
        return;
    }
}