package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    //напишите тут ваш код
    //Имя(String), возраст(int), пол(char).
    public String name;
    public int age;
    public char sex;

    public void initialize (String name) {
        this.name = name;
        this.age = 10;
        this.sex = 'M';
    }

    public void initialize (String name, int age) {
        this.name = name;
        this.age = age;
        this.sex = 'M';
    }

    public void initialize (String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
