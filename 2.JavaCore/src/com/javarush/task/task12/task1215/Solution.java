package com.javarush.task.task12.task1215;

/* 
Классы Cat и Dog от Pet
Унаследуй классы Cat и Dog от Pet.
Реализуй недостающие методы.
Классы Cat и Dog не должны быть абстрактными.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet{
        @Override
        public String getName() {return "";};
        @Override
        public Pet getChild() {return this;};

    }

    public static class Dog extends Pet{
        @Override
        public String getName() {return "";};
        @Override
        public Pet getChild() {return this;};
    }

}
