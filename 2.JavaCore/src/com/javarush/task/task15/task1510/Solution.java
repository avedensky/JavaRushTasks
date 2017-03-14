package com.javarush.task.task15.task1510;

/* 
Все лишнее - прочь!
Убрать в методе main лишние строки, для которых метод add не реализован.
*/

public class Solution {
    public static void main(String[] args) {
        add((short) 1, 2f); //2
        add(1, 2);       //1
        add(2d, 2);      //3
        //add("1",2d);         //error
        add((byte) 1, 2d);  //2
    }

    public static void add(int i, int j) {
        System.out.println("Integer addition");
    }

    public static void add(int i, double j) {
        System.out.println("Integer and double addition");
    }

    public static void add(double i, double j) {
        System.out.println("Double addition");
    }
}
