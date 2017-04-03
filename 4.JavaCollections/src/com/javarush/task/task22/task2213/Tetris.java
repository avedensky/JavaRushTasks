package com.javarush.task.task22.task2213;


/**
 * Created by Alexey Vedensky on 03.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Tetris {
    static Tetris game;

    private Field field;
    private Figure figure;

    public void run() {

    }

    public void step() {

    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }


    public static void main(String[] args) {
        System.out.println("Start Tetris");

        game = new Tetris();
        game.run();
    }
}
