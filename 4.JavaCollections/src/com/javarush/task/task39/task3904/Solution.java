package com.javarush.task.task39.task3904;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Лестница

Ребенок бежит по лестнице состоящей из N ступенек, за 1 шаг он может пройти одну, две или три ступеньки.

Реализуй метод countPossibleRunups(int n), который вернет количество способов которыми ребенок может
пробежать всю лестницу состоящую из n ступенек.

P.S. Если лестница состоит из 0 ступенек — метод должен возвращать 1. Для n < 0 верни 0.


Требования:
1. Метод countPossibleRunups должен возвращать количество способов прохождения лестницы из n ступенек.
2. Метод countPossibleRunups должен возвращать 1 для n = 0.
3. Метод countPossibleRunups должен возвращать 0 для n < 0.
4. Время выполнения метода countPossibleRunups должно быть линейным.
*/

//Валидацию не прошло
public class Solution {
    private static int n = 70;

    public static void main(String[] args) {
        System.out.println("Number of possible runups for " + n + " stairs is: " + countPossibleRunups(n));
    }

    public static long countPossibleRunups(int n) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        ArrayList<Integer> values = new ArrayList<>();
        values.add(1); //1
        values.add(2);
        values.add(3);

        int i;
        for (i = 3; i <= n; i++) {
            values.add(values.get(i - 1) + values.get(i - 2) + values.get(i - 3));
            //System.out.println(values.get(i));
        }

        return values.get(values.size()-1);

    }
}

