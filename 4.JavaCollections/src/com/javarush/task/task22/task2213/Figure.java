package com.javarush.task.task22.task2213;

/**
 * Created by Alexey Vedensky on 03.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Figure {
    private int x;
    private int y;
    private int[][] matrix;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

//    public void setX(int x) {
//        this.x = x;
//    }

    public int getY() {
        return y;
    }

//    public void setY(int y) {
//        this.y = y;
//    }

    public int[][] getMatrix() {
        return matrix;
    }

//    public void setMatrix(int[][] matrix) {
//        this.matrix = matrix;
//    }

    //для движения фигурки влево.
    public void left() {

    }

    //для движения фигурки вправо.
    public void right() {

    }

    //для движения фигурки вниз.
    public void down() {

    }

    //для движения фигурки вверх.
    public void up() {

    }

    //для поворота фигурки вокруг главной диагонали.
    public void rotate() {

    }

    //падение фигурки в низ до дна.
    public void downMaximum() {

    }

    //проверка — может ли фигурка быть помещена в текущую позицию
    boolean isCurrentPositionAvailable() {
        return true;
    }

    //вызывается, когда фигурка достигла дна или уперлась в другую фигурку
    //Все ее занятые клетки теперь должны добавиться в Field.
    public void landed() {

    }
}
