package com.javarush.task.task15.task1528;

/* 
ООП - наследование
Исправь класс Hrivna так, чтоб избежать возникновения ошибки StackOverflowError.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Hrivna().getAmount());
    }

    public static abstract class Money {
        abstract Money getMoney();

        public Object getAmount() {
            return getMoney().getAmount();
        }
    }

    //add your code below - добавь код ниже
    public static class Hrivna extends Money {
        public double amount = 123d;

        public Hrivna getMoney() {
            return this;
        }

        public Double getAmount() {
            return amount;
        }
    }
}
