package com.javarush.task.task35.task3502;

import java.util.List;

/*
Знакомство с дженериками

Параметризируй классы SomeClass и Solution следующим образом:
1. SomeClass должен работать с типами, которые наследуются от Number;
2. Solution должен работать с типами, которые наследуются от List, который в свою очередь параметризируется типом SomeClass.


Требования:
1. Класс SomeClass должен работать с типами которые наследуются от Number.
2. Класс Solution должен работать с типами, которые наследуются от List, который в свою очередь параметризируется типом SomeClass.
3. Класс SomeClass должен быть публичным.
4. Класс SomeClass должен быть статическим.
5. Класс SomeClass должен находиться внутри класса Solution.
*/
public class Solution <T1 extends List<Solution.SomeClass>> {
    public static class SomeClass <T3 extends Number> {
    }

    public static void main(String[] args) {

    }
}
