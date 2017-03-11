package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        if (a==1) {
            System.out.println("понедельник");
            return;
        }
        if (a==2) {
            System.out.println("вторник");
            return;
        }
        if (a==3) {
            System.out.println("среда");
            return;
        }
        if (a==4) {
            System.out.println("четверг");
            return;
        }
        if (a==5) {
            System.out.println("пятница");
            return;
        }
        if (a==6) {
            System.out.println("суббота");
            return;
        }
        if (a==7) {
            System.out.println("воскресенье");
            return;
        }
        if (a<1 || a>7) {
            System.out.println("такого дня недели не существует");
            return;
        }
    }
}