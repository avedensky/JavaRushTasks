package com.javarush.task.task25.task2515;

/**
 * Created by Alexey Vedensky on 07.04.2017.
 * MAIL: avedensky@gmail.com
 */
public class SpaceShip extends BaseObject {
    private double dx;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
        dx = 0;
    }

    public void moveLeft() {
        dx = -1;
    }

    public void moveRight() {
        dx = 1;
    }

    @Override
    public void draw(Canvas canvas) {}

    public void fire() {
        Rocket rocket1 = new Rocket(x-2,y);
        Rocket rocket2 = new Rocket(x+2,y);
        Space.game.getRockets().add(rocket1);
        Space.game.getRockets().add(rocket2);
    }

    @Override
    public void move() {
        x +=dx;

        checkBorders(radius, Space.game.getWidth() - radius + 1, 1, Space.game.getHeight() + 1);
    }
}
