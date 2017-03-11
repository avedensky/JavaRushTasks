package com.javarush.task.task04.task0436;


/* 
Рисуем прямоугольник
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner (System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i=0;i<a;i++) {
            for (int j = 0; j < b; j++) {
                System.out.print("8");
            }
            System.out.println();
        }

    }
}
