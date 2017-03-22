package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

/* 
Задача по алгоритмам

Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа — в убывающем.

Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз

Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);
        System.out.println("----------------");

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        ArrayList<Integer> digitalList = new ArrayList<>();
        ArrayList<String> stringList = new ArrayList<>();

        for (String s : array) {
            if (isNumber(s))
                digitalList.add(Integer.parseInt(s));
            else
                stringList.add(s);
        }

        for (int i = 0; i < digitalList.size(); i++)
            for (int j = i + 1; j < digitalList.size(); j++)
                if (digitalList.get(i) < digitalList.get(j)) {
                    int tmp = digitalList.get(i);
                    digitalList.set(i, digitalList.get(j));
                    digitalList.set(j, tmp);
                }

        for (int i = 0; i < stringList.size(); i++)
            for (int j = i + 1; j < stringList.size(); j++)
                if (isGreaterThan(stringList.get(i), (stringList.get(j)))) {
                    String tmp = stringList.get(i);
                    stringList.set(i, stringList.get(j));
                    stringList.set(j, tmp);
                }

        int jd = 0, js = 0;
        for (int i = 0; i < array.length; i++)
            if (isNumber(array[i])) {
                array[i] = digitalList.get(jd).toString();
                jd++;
            } else {
                array[i] = stringList.get(js);
                js++;
            }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
