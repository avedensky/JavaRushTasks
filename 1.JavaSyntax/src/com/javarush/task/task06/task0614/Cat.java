package com.javarush.task.task06.task0614;

import sun.util.resources.cldr.ar.CalendarData_ar_TN;

import java.util.ArrayList;

/* 
Статические коты
*/

public class Cat {
    //напишите тут ваш код
    public static ArrayList<Cat> cats = new ArrayList<>();

    public Cat() {
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i=0;i<10;i++) {
            Cat c= new Cat();
            Cat.cats.add(c);
        }

        printCats();
    }

    public static void printCats() {
        //напишите тут ваш код
        for (int i=0;i<cats.size();i++) {
            System.out.println(cats.get(i));
        }

    }
}
