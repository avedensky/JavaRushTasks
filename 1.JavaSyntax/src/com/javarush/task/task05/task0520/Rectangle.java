package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    public int top, left, width, height;

    public Rectangle (int top, int left, int width, int height) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }


    public Rectangle (int top, int left) {
        this.top = top;
        this.left = left;
        this.width = 0;
        this.height = 0;
    }


    public Rectangle (int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = width;
    }


    public Rectangle (Rectangle rec) {
        this.top = rec.top;
        this.left = rec.left;
        this.width = rec.width;
        this.height = rec.width;
    }

    public static void main(String[] args) {

    }
}
