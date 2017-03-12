package com.javarush.task.task12.task1210;

/* 
Три метода возвращают максимальное из двух переданных в него чисел
Написать public static методы: int max(int, int), long max(long, long), double max(double, double).
Каждый метод должен возвращать максимальное из двух переданных в него чисел.
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static int max(int a, int b) {
        return a > b ? a : b ;
    }

    public static long max(long a, long b) {
        return a > b ? a : b ;
    }

    public static double max(double a, double b) {
        return a > b ? a : b ;
    }

}
