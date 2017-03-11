package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        System.out.println (convertEurToUsd (10, 1.1));
        System.out.println (convertEurToUsd (30, 1.2));
    }

    public static double convertEurToUsd(int eur, double course) {
        //напишите тут ваш код
        //долларСША = евро * курс
        double dollar = eur * course;
        return dollar;
    }
}
