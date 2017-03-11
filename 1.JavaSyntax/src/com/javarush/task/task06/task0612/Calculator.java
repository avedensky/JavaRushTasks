package com.javarush.task.task06.task0612;

/* 
Калькулятор
*/

public class Calculator {
    public static int plus(int a, int b) {
        //напишите тут ваш код
        return a+b;
    }

    public static int minus(int a, int b) {
        //напишите тут ваш код
        return a-b;
    }

    public static int multiply(int a, int b) {
        //напишите тут ваш код
        return a*b;
    }

    public static double division(int a, int b) {
        //напишите тут ваш код
        double c = a;
        double d = b;
        return c/d;
    }

    public static double percent(int a, int b) {
        //напишите тут ваш код
        double one_prc = a/100;
        return one_prc * b;
    }

    public static void main(String[] args) {

    }
}