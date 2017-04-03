package com.javarush.task.task22.task2213;

/**
 * Created by Alexey Vedensky on 03.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new int[height][width];
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

    public int[][] getMatrix() {
        return matrix;
    }

    //объект будет отрисовывать на экран свое текущее состояние
    public void print() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++)
                if (matrix[y][x] == 0)
                    System.out.print(".");
                else
                    System.out.print("X");

            System.out.println();
        }

    }

    //будет удалять из матрицы полностью заполненные строки и сдвигать вышележащие строки вниз
    public void removeFullLines() {

    }

    //возвращает значение которое находится в матрице с координатами x и y
    public Integer getValue(int x, int y) {
        return matrix[y][x];
    }

    //устанавливает переданное значение в ячейку массива (матрицы)
    void setValue(int x, int y, int value) {
        matrix[y][x] = value;
    }

}
