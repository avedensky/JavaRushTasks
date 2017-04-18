package com.javarush.task.task38.task3802;

/* 
Проверяемые исключения (checked exception)

Напиши реализацию метода veryComplexMethod().
Он должен всегда кидать какое-нибудь проверяемое исключение.
Кинуть исключение (throw) явно нельзя.


Требования:
1. Метод veryComplexMethod класса veryComplexClass не должен использовать ключевое слово throw.
2. Метод veryComplexMethod класса veryComplexClass должен бросать исключение.
3. Брошенное исключение НЕ должно быть исключением времени выполнения(RuntimeException).
4. Метод veryComplexMethod не должен быть приватным.
*/

import java.io.FileNotFoundException;
import java.io.FileReader;

public class VeryComplexClass {
    public void veryComplexMethod() throws Exception {
        //напишите тут ваш код
        FileReader fileReader = new FileReader("unknown.file.txt");

    }

    public static void main(String[] args) {

    }
}
