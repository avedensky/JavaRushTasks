package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Vedensky on 17.05.2017.
 * MAIL: avedensky@gmail.com
 */
public class Snake {
    private List<SnakeSection> sections;

    private boolean isAlive;
    private SnakeDirection direction;


    public Snake(int x, int y) {
        sections = new ArrayList<>();
        this.isAlive = true;

        SnakeSection snakeSection = new SnakeSection(x, y);
        sections.add(snakeSection);
    }

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

    public int getX() {
        return sections.get(0).getX();
    }

    public int getY() {
        return sections.get(0).getY();
    }

    /*
    В методе move без параметров необходимо:
    а) прекратить движение если змея умерла(isAlive == false)
    б) вызвать метод move(0, -1) если направление движения равно SnakeDirection.UP
    в) вызвать метод move(1, 0) если направление движения равно SnakeDirection.RIGHT
    г) вызвать метод move(0, 1) если направление движения равно SnakeDirection.DOWN
    д) вызвать метод move(-1, 0) если направление движения равно SnakeDirection.LEFT
     */
    public void move() {
        if (isAlive){
            if (direction==SnakeDirection.UP){
                move(0,-1);
            } else if (direction==SnakeDirection.RIGHT){
                move(1,0);
            } else if (direction==SnakeDirection.DOWN){
                move(0,1);
            } else if (direction==SnakeDirection.LEFT){
                move(-1,0);
            }
        }
    }

    public void move (int x, int y) {

    }
}
