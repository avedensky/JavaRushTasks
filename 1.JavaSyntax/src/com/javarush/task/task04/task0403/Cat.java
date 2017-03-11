package com.javarush.task.task04.task0403;

/* 
Реализовать метод setName
*/

public class Cat {
    private String name;

    public void setName(String name) {
        //напишите тут ваш код
        this.name = name;
    }

    public static void main(String[] args) {
        Cat cat = new Cat ();
        cat.setName("Vasya");

    }
}
