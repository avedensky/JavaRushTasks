package com.javarush.task.task22.task2213;


/**
 * Класс Figure описывает фигурку тетриса
 */
public class Figure {
    //метрица которая определяет форму фигурки: 1 - клетка не пустая, 0 - пустая
    private int[][] matrix;
    //координаты
    private int x;
    private int y;

    public Figure(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Поворачиваем фигурку.
     * Для простоты - просто вокруг главной диагонали.
     */
    public void rotate() {
        int[][] matrix2 = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix2[i][j] = matrix[j][i];
            }
        }

        matrix = matrix2;
    }

    /**
     * Двигаем фигурку влево.
     * Проверяем не вылезла ли она за границу поля и/или не залезла ли на занятые клетки.
     */
    public void left() {
        x--;
        if (!isCurrentPositionAvailable())
            x++;
    }

    /**
     * Двигаем фигурку вправо.
     * Проверяем не вылезла ли она за границу поля и/или не залезла ли на занятые клетки.
     */
    public void right() {
        x++;
        if (!isCurrentPositionAvailable())
            x--;
    }

    /**
     * Двигаем фигурку вверх.
     * Используется, если фигурка залезла на занятые клетки.
     */
    public void up() {
        y--;
    }

    /**
     * Двигаем фигурку вниз.
     */
    public void down() {
        y++;
    }

    /**
     * Двигаем фигурку вниз до тех пор, пока не залезем на кого-нибудь.
     */
    public void downMaximum() {
        while (isCurrentPositionAvailable()) {
            y++;
        }

        y--;
    }

    /**
     * Проверяем - может ли фигурка находится на текущей позиции:
     * а) не выходит ли она за границы поля
     * б) не заходит ли она на занятые клетки
     */
    public boolean isCurrentPositionAvailable() {
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 1) {
                    if (y + i >= field.getHeight())
                        return false;

                    Integer value = field.getValue(x + j, y + i);
                    if (value == null || value == 1)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * Приземляем фигурку - добавляем все ее непустые клетки к клеткам поля.
     */
    public void landed() {
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 1)
                    field.setValue(x + j, y + i, 1);
            }
        }
    }
}
