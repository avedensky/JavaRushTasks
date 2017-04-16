package com.javarush.task.task36.task3613;

import java.util.concurrent.SynchronousQueue;


/*
Найти класс по описанию

Описание класса:
1. Пакет этого класса java.util.concurrent.
2. Реализует интерфейс BlockingQueue.
3. Используется при работе с трэдами.
4. Является блокирующей очередью, в которой каждая операция добавления должна ждать соответствующей
операции удаления в другом потоке и наоборот.
5. Не имеет никакой внутренней емкости, даже емкости в один элемент.

Метод getExpectedClass() должен вернуть класс в виде XXX.class, где
XXX — название класса.


Требования:
1. В методе getExpectedClass не должны вызываться никакие методы.
2. Метод getExpectedClass должен вернуть правильный тип.
3. Метод main должен вызывать метод getExpectedClass.
4. Метод main должен вывести полученный класс на экран.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return SynchronousQueue.class;
    }
}