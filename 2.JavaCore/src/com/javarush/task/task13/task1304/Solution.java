package com.javarush.task.task13.task1304;

/* 
Selectable и Updatable

Создай класс Screen и реализуй в нем интерфейсы Selectable и Updatable.
Не забудь реализовать методы!
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    interface Selectable {
        void onSelect();
    }

    interface Updatable {
        void refresh();
    }

    //напишите тут ваш класс
    public class Screen implements Selectable, Updatable {

        @Override
        public void onSelect() {

        }

        @Override
        public void refresh() {

        }
    }
}
