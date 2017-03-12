package com.javarush.task.task13.task1316;

/* 
Некорректные строки
Удали все некорректные строки в интерфейсе Button.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        System.out.println(SimpleObject.NAME);
        System.out.println(Button.NAME);
    }

    interface SimpleObject {
        String NAME = "SimpleObject";

        void onPress();
    }

    interface Button extends SimpleObject {

        String NAME = "Submit";

        String onPress(Object o);
    }
}