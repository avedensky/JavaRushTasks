package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        //int[] vect = new int [4];

//        Scanner sc = new Scanner(System.in);
//        int max = 0;
//        int a = 0;
//        for (int i=0;i<4;i++) {
////            System.out.print("Введите "+(i+1)+" число :");
//            a = sc.nextInt();
//            if (max <= a) {
//                max = a;
//            }
//        }
//        System.out.println(max);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n1 = Integer.parseInt(reader.readLine());
        int n2 = Integer.parseInt(reader.readLine());
        int n3 = Integer.parseInt(reader.readLine());
        int n4 = Integer.parseInt(reader.readLine());

        System.out.println(Math.max(Math.max(Math.max(n1,n2), n3),n4));

    }
}
