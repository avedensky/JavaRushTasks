package com.javarush.task.task35.task3511;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Wildcards для коллекций

В классе Solution реализовано 4 метода для работы со списками:
sum — суммирует все элементы списка, в котором находятся любые числа,
multiply — перемножает между собой все элементы списка, в котором находятся любые числа,
concat — соединяет все элементы списка в одну строку,
combine — принимает на вход список любых коллекций и возвращает результирующий список, в котором находятся все элементы из списков.

Добавь для каждого входящего типа List подходящий шаблон (wildcard), чтобы метод мог принимать только те элементы, которые может обработать.


Требования:
1. Для типа параметра метода sum(List list) нужно добавить подходящий шаблон (wildcard).
2. Для типа параметра метода multiply(List list) нужно добавить подходящий шаблон (wildcard).
3. Для типа параметра метода concat(List list) нужно добавить подходящий шаблон (wildcard).
4. Для типа параметра метода combine(List list) нужно добавить подходящий шаблон (wildcard).
*/
public class Solution {

    public static void main(String[] args) {
    }

    public static Double sum(List<? extends Number> list) {
        Double result = 0.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = (Number) list.get(i);
            result += numb.doubleValue();
        }
        return result;
    }

    public static Double multiply(List<? extends Number> list) {
        Double result = 1.0;
        for (int i = 0; i < list.size(); i++) {
            Number numb = (Number) list.get(i);
            result *= numb.doubleValue();
        }
        return result;
    }

    public static String concat(List<?> list) {
        StringBuilder builder = new StringBuilder();
        for (Object obj : list) {
            builder.append(obj);
        }
        return builder.toString();
    }

    public static List combine(List<? extends Collection> list) {
        List result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Collection collection = (Collection) list.get(i);
            result.addAll(collection);
        }
        return result;
    }
}
