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
}
