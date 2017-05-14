package com.javarush.task.task34.task3410.model;

import java.awt.*;

/**
 * Created by Alexey on 14.05.2017.
 */

//
//Добавь в класс GameObject два конструктора: GameObject(int x, int y) и GameObject(int x, int y, int width, int height).
//        Конструкторы должны инициализировать все поля класса, согласно условию задачи.
public abstract class GameObject {
    private int x, y, width, height;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = Model.FIELD_CELL_SIZE;
        this.height = Model.FIELD_CELL_SIZE;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public abstract void draw(Graphics graphics);

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
