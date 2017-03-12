package com.javarush.task.task12.task1232;

/* 
Нужно добавить в программу новую функциональность
Сделать класс Pegas(пегас) на основе класса Horse(лошадь) и интерфейса Fly(летать).
*/

public class Solution {
    public static void main(String[] args) {
        Pegas horse = new Pegas();
    }

    public static interface Fly {
        public void fly();
    }

    public static class Horse {
        public void run() {

        }
    }

    public static class Pegas extends Horse implements Fly{
        @Override
        public void fly() {

        }
    }
}
