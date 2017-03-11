package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i=1; i<11; i++) {
            for (int j=1; j<11; j++) {
                System.out.print(i*j+" ");
            }
            System.out.println ();
        }
    }
}
