package com.javarush.task.task19.task1912;

/* 
Ридер обертка 2

В методе main подмените объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна заменять все подстроки «te» на «??«.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.
Выведи модифицированную строку в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething ();

        System.setOut(consoleStream);
        System.out.println(outputStream.toString().replace("te","??"));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
