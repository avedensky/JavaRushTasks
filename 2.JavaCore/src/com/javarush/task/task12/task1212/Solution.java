package com.javarush.task.task12.task1212;

/* 
Исправь код. Первая задача
*/

public class Solution {
    public static void main(String[] args) {

    }

    public abstract static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }
}
