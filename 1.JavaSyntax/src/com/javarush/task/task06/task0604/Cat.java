package com.javarush.task.task06.task0604;

/* 
Ставим котов на счётчик
*/

public class Cat {
    public static int catCount = 0;

    //напишите тут ваш код
    public Cat () {
        catCount += 1;
    }

    @Override
    protected void finalize() {
        catCount -= 1;
    }

    public static void main(String[] args) {

    }
}