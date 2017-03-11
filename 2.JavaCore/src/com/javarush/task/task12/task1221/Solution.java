package com.javarush.task.task12.task1221;

/* 
Метод getName в классе Cat
*/

public class Solution {
    public static void main(String[] args) {
        Pet pet = new Cat();

        System.out.println(pet.getName());
    }

    public static class Pet {
        public String getName() {
            return "Я - пушистик";
        }
    }

    public static class Cat extends Pet {
        @Override
        public String getName()
        {
            return "Я - кот";
        }

    }
}
