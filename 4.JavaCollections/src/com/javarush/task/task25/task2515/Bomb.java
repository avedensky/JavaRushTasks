package com.javarush.task.task25.task2515;

/**
 * Created by Alexey Vedensky on 07.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class Bomb extends BaseObject {
    public Bomb(double x, double y) {
        super(x, y, 1);
    }

    public void move() {
        y++;
    }

    public void draw(Canvas canvas) {
        canvas.setPoint(x,y,'B');
    }
}
