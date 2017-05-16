package com.javarush.task.task23.task2312;

import java.util.List;

/**
 * Created by Alex Vedensky on 14.05.2017.
 * MAIL: avedensky@gmail.com
 */
public class Snake {
    private List<SnakeSection> sections;

    private boolean isAlive;
    private SnakeDirection direction;

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
}
