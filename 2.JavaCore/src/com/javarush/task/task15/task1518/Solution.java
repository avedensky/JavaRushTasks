package com.javarush.task.task15.task1518;

/* 
Статики 3

1. В классе Solution создай класс Cat с публичным полем name типа String.
2. В статическом блоке создай объект типа Cat и присвой его переменной cat(не забудь инициализировать поле name).
3. В классе Cat не создавай конструкторы с параметрами.
4. В статическом блоке выведи имя созданного кота на экран.
*/

public class Solution {
    public static Cat cat;

    static {
        cat = new Cat ();
        cat.name = "Barsik";
        System.out.println(cat.name);
    }

    public static class Cat {
        public String name;

    }

    public static void main(String[] args) {

    }


}
