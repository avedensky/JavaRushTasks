package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer

Используя StringTokenizer разделить query на части по разделителю delimiter.

Пример
getTokens("level22.lesson13.task01", ".")

Возвращает
{"level22", "lesson13", "task01"}


Требования:
1. Метод getTokens должен использовать StringTokenizer.
2. Метод getTokens должен быть публичным.
3. Метод getTokens должен принимать два параметра типа String.
4. Массив типа String возвращенный методом getTokens должен быть заполнен правильно(согласно условию задачи).
*/
public class Solution {
    public static void main(String[] args) {
        String[] strings = getTokens("Orange,Green,Yellow,Red",",");

        for (String s : strings)
            System.out.println(s);
    }

    public static String [] getTokens(String query, String delimiter) {

        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] result = new String[st.countTokens()];

       for (int i=0; st.hasMoreElements();i++) {
           result[i] = st.nextToken();
       }

        return result;
    }
}
