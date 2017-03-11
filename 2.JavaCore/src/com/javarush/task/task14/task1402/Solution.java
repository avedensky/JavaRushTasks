package com.javarush.task.task14.task1402;

/* 
Bingo-2!

Исправь строчку ‘Cat cat = new Cat();‘ так, чтобы программа вывела «Bingo!«.
*/

public class Solution {
    public static void main(String[] args) {
        Cat cat = new TomCat();

        boolean isCat = cat instanceof Cat;
        boolean isMovable = cat instanceof Movable;
        boolean isTom = cat instanceof TomCat;

        if (isCat && isMovable && isTom) System.out.println("Bingo!");
    }

    interface Movable {
    }

    static class Cat implements Movable {
    }

    static class TomCat extends Cat {

    }
}
