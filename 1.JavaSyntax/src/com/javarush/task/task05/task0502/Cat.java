package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public String name;
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        //напишите тут ваш код
        if (this.age<anotherCat.age)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat ();
        Cat cat2 = new Cat ();
        cat1.age = 3;
        cat2.age = 5;


    }
}


