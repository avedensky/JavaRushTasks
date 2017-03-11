package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    //напишите тут ваш код
    //напишите тут ваш код
    private String name = null;
    private int weight; //weight
    private int age;
    private String color = null;
    private String address = null;

    public Cat (String name) {
        this.name = name;
        this.weight = 5;
        this.age = 5;
        this.color = "black";
    }

    public Cat (String name, int weight, int age) {
        this.name = name;
        this.weight= weight;
        this.age = age;
        this.color = "black";
    }

    public Cat (String name, int age) {
        this.name = name;
        this.weight= 5;
        this.age = age;

    }

    public Cat (int weight, String color) {
        this.weight= weight;
        this.age = 5;
        this.color = color;
    }

    public Cat (int weight, String color, String address) {
        this.weight= weight;
        this.age = 5;
        this.color = color;
        this.address = address;
    }

    public static void main(String[] args) {

    }
}
