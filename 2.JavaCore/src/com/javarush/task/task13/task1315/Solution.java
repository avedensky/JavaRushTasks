package com.javarush.task.task13.task1315;

/* 
Dog, Cat и Mouse
*/

public class Solution {
    public static void main(String[] args) {

    }
    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }

    class Dog implements Movable, Eat{

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }
    class Cat implements Movable, Eatable, Eat{

        @Override
        public void move() {

        }

        @Override
        public void eaten() {

        }

        @Override
        public void eat() {

        }
    }
    class Mouse implements Movable, Eatable {

        @Override
        public void move() {

        }

        @Override
        public void eaten() {

        }
    }
}