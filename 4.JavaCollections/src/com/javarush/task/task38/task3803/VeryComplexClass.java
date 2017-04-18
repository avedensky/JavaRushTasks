package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)

Напиши реализацию метода methodThrowsClassCastException(). Он должен всегда кидать
Runtime исключение ClassCastException.

Напиши реализацию метода methodThrowsNullPointerException(). Он должен всегда кидать
Runtime исключение NullPointerException.

Кинуть исключение (throw) явно нельзя.


Требования:
1. Метод methodThrowsClassCastException класса veryComplexClass не должен использовать ключевое слово throw.
2. Метод methodThrowsNullPointerException класса veryComplexClass не должен использовать ключевое слово throw.
3. Метод methodThrowsClassCastException класса veryComplexClass должен бросать исключение ClassCastException.
4. Метод methodThrowsNullPointerException класса veryComplexClass должен бросать исключение NullPointerException.
*/

public class VeryComplexClass {
    public void methodThrowsClassCastException() throws ClassCastException {
        Object ch = new Character('*');
        System.out.println((Byte)ch);
    }

    public void methodThrowsNullPointerException() throws NullPointerException {
        int[] array = null;
        System.out.println(array.length);

    }

    public static void main(String[] args) {
        VeryComplexClass o = new VeryComplexClass();
        o.methodThrowsNullPointerException ();

    }
}
