package com.javarush.task.task12.task1205;

/* 
Или «Корова», или «Кит», или «Собака», или «Неизвестное животное»
Написать метод, который определяет, объект какого класса ему передали, и возвращает результат –
одно значение из: «Корова», «Кит», «Собака», «Неизвестное животное».
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Dog()));
        System.out.println(getObjectType(new Whale()));
        System.out.println(getObjectType(new Pig()));
    }

    public static String getObjectType(Object o) {
        //Напишите тут ваше решение
        String s = "Неизвестное животное";
        if (o instanceof Cow)
            s = "Корова";

        if (o instanceof Whale)
            s = "Кит";

        if (o instanceof Dog)
            s = "Собака";

        return s;
    }

    public static class Cow {
    }

    public static class Dog {
    }

    public static class Whale {
    }

    public static class Pig {
    }
}
