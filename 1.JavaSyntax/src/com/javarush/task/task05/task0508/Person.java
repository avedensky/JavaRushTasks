package com.javarush.task.task05.task0508;

/* 
Геттеры и сеттеры для класса Person
*/

public class Person {

    //напишите тут ваш код
    private String name;
    private int age;
    private char sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Person () {
        this.name = "";
        this.age = 0;
        this.sex = 'M';
    }

    public Person (String naem, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
