package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex Vedensky on 17.05.2017.
 * MAIL: avedensky@gmail.com
 */
public class Snake {
    private ArrayList<SnakeSection> sections;
    //private ArrayList<SnakeSection> sections = new ArrayList<>();


    private boolean isAlive;
    private SnakeDirection direction;


    public Snake(int x, int y) {
        this.sections = new ArrayList<>();
        this.isAlive = true;

        SnakeSection snakeSection = new SnakeSection(x, y);
        sections.add(snakeSection);
    }

    public ArrayList<SnakeSection> getSections() {
        return this.sections;
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
    Ничто не вечно. Так и змея должна умирать, если она врезается в стену или саму себя.

Для определения, не пересекается ли змея сама с собой, можно сделать очень простую проверку:
содержит ли список sections «новую голову змеи«.

Код для этого будет выглядеть примерно так:
if (sections.contains(head))

При этом head должен быть еще не добавлен в список sections, иначе будет всегда true.
Но чтобы этот код работал, надо реализовать методы сравнения объектов (equals и hashCode) в классе SnakeSection.

    б) реализуй метод checkBorders(SnakeSection head): если голова змеи за границами комнаты — змея умирает (isAlive = false)
    в) реализуй метод checkBody(SnakeSection head): если голова змеи пересекается с ее телом — змея умирает (isAlive = false)
     */

    //Validator не принял
    private void checkBorders(SnakeSection head) {
        if (head.getX() < 0)
            isAlive = false;
        if (head.getX() >= Room.game.getWidth())
            isAlive = false;
        if (head.getY() < 0)
            isAlive = false;
        if (head.getY() >= Room.game.getHeight())
            isAlive = false;
    }


    private void checkBody(SnakeSection head) {
        if (sections.contains(head)) {
            isAlive = false;
        }
    }

    public void move() {
        if (isAlive) {
            if (direction == SnakeDirection.UP) {
                move(0, -1);
            } else if (direction == SnakeDirection.RIGHT) {
                move(1, 0);
            } else if (direction == SnakeDirection.DOWN) {
                move(0, 1);
            } else if (direction == SnakeDirection.LEFT) {
                move(-1, 0);
            }
        }
    }

    public void move(int x, int y) {

    }
}
