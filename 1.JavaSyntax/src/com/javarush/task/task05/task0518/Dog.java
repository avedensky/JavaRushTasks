package com.javarush.task.task05.task0518;

/* 
Регистрируем собачек
*/


public class Dog {
    //напишите тут ваш код
    private String name;
    private int height;
    private String color;

    public Dog (String name) {
        this.name = name;
    }

    public Dog (String name, int height) {
        this.name = name;
        this.height = height;
    }

    public Dog (String name, int height, String color) {
        this.name = name;
        this.height = height;
        this.color = color;
    }

    public static void main(String[] args) {

    }
}
