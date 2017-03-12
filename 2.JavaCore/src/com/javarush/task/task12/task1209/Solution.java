package com.javarush.task.task12.task1209;

/* 
Три метода возвращают минимальное из двух переданных в него чисел
Написать public static методы: int min(int, int), long min(long, long), double min(double, double).
Каждый метод должен возвращать минимальное из двух переданных в него чисел.
*/

public class Solution {
    public static void main(String[] args) {

    }

    //Напишите тут ваши методы
    public static int min (int a, int b) {
        return a < b ? a : b ;
    }

    public static long min (long a, long b) {
        return a < b ? a : b ;
    }

    public static double min (double a, double b) {
        return a < b ? a : b ;
    }
}
