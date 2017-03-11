package com.javarush.task.task06.task0603;

/* 
По 50 000 объектов Cat и Dog
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Cat[] cats = new Cat[50000];
        Dog[] dogs = new Dog[50000];

        for (int i=0;i<50000;i++) {
            cats[i] = new Cat ();
            dogs[i] = new Dog ();
        }
    }
}

class Cat {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Cat was destroyed");
    }
}

class Dog {
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Dog was destroyed");
    }
}
