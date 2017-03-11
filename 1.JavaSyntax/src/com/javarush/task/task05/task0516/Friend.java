package com.javarush.task.task05.task0516;

/* 
Друзей не купишь
*/

public class Friend {
    //напишите тут ваш код
    private String name = null;
    private int age = 0;
    private char sex = 'M';

    public Friend (String name) {
        this.name = name;
    }

    public Friend (String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Friend (String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
