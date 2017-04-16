package com.javarush.task.task37.task3703;

import java.util.concurrent.ConcurrentSkipListMap;

/*
Найти класс по описанию

Метод getExpectedClass должен возвращать класс который:
1. Реализует интерфейс Map.
2. Используется при работе с трэдами.
3. Является неблокирующей версией списка с пропусками, который адаптирован для хеш-таблицы.
Про список с пропусками читать в дополнительном материале к этой лекции.


Требования:
1. Метод getExpectedClass должен возвращать класс описанный в условии задачи.
2. Класс возвращенный методом getExpectedClass должен быть потомком класса AbstractMap.
3. Класс возвращенный методом getExpectedClass должен поддерживать интерфейс ConcurrentNavigableMap.
4. Класс возвращенный методом getExpectedClass должен поддерживать интерфейс Serializable.
5. Класс возвращенный методом getExpectedClass должен поддерживать интерфейс Cloneable.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return ConcurrentSkipListMap.class;
    }
}
