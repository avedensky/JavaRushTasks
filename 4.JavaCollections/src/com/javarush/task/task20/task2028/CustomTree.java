package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.List;

/* 
Построй дерево(1)
Амиго, похоже ты уже достаточно окреп. Самое время проверить свои навыки в большой задаче!
Сегодня реализуем свое дерево немного нестандартным способом(на базе AbstractList).
Вводную информацию можешь получить используя свой любимый поисковик и текст ниже.

Элементы дерева должны следовать так как показано на картинке:
http://info.javarush.ru/uploads/images/00/04/89/2014/03/21/ee9a9b.jpg

Для начала сделаем наше дерево потомком класса AbstractList с параметром типа String, а также
реализуем интерфейсы Cloneable и Serializable.

Реализацию методов get(int index) и size() пока оставь стандартной.


Требования:
1. Класс CustomTree должен поддерживать интерфейс Cloneable.
2. Класс CustomTree должен поддерживать интерфейс Serializable.
3. Класс CustomTree должен быть потомком класса AbstractList.
*/
public class CustomTree extends AbstractList implements Cloneable, Serializable {
    public static void main(String[] args) {
        List<String> list = new CustomTree();
        for (int i = 1; i < 16; i++) {
            list.add(String.valueOf(i));
        }
        //System.out.println("Expected 3, actual is " + ((CustomTree) list).getParent("8"));
        list.remove("5");
        //System.out.println("Expected null, actual is " + ((CustomTree) list).getParent("11"));
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
