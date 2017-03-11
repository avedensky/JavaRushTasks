package com.javarush.task.task12.task1204;

/* 
Или «Кошка», или «Собака», или «Птица», или «Лампа»
*/

public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        //Напишите тут ваше решение
        if (o instanceof Cat)
            System.out.println("Кошка");

        if (o instanceof Dog)
            System.out.println("Собака");

        if (o instanceof Bird)
            System.out.println("Птица");

        if (o instanceof Lamp)
            System.out.println("Лампа");
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
