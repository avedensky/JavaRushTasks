package com.javarush.task.task15.task1513;

/* 
Максимально простой код 3

Упрости код:
— убери всё то, что будет генерироваться автоматически при компиляции
— убери все наследования классов, которые и так будут добавлены автоматически при компиляции
— убери все конструкторы, которые создаются и добавляются автоматически.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public interface Runnable {

    }

    public class Machine implements Runnable {
//        public Machine()
//        {
//            super();
//        }
    }

    public class Car extends Machine { //implements Runnable {
//        public Car() {
//            super();
//        }
    }
}
