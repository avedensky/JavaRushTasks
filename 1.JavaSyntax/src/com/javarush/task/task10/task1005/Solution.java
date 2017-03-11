package com.javarush.task.task10.task1005;

/* 
Задача №5 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        int a = (int) 44;
        int b = (int) 300;
        short c = (short) (b - a);
        System.out.println(c);
    }
}