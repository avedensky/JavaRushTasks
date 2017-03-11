package com.javarush.task.task05.task0501;

/* 
Создание кота
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age, weight, strength;
    Cat () {
        this.name="";
        this.age=0;
        this.weight = 0;
        this.strength = 0;
    }

    Cat (String name, int age, int weight, int strength) {
        this.name=name;
        this.age=age;
        this.weight = weight;
        this.strength = strength;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setWeight(int weight) {
        this.weight=weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setStrength(int strength) {
        this.strength=strength;
    }

    public int getCatStrength()
    {
        return strength;
    }
//    private String name;
//    private int age;
//    private int weight;
//    private int strength;
//
//    public Cat(String name, int age, int weight, int strength) {
//        this.name = name;
//        this.age = age;
//        this.weight = weight;
//        this.strength = strength;
//    }


    //public Cat (String name, int age, int weight, int strength) {








    public static void main(String[] args) {
        Cat cat = new Cat("Barsik", 2, 3,12 );
        //Cat cat =new Cat ("Bob", 5,4,8);

    }
}
