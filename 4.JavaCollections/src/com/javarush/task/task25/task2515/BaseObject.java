package com.javarush.task.task25.task2515;

/**
 * Created by Alexey Vedensky on 07.04.2017.
 * MAIL: avedensky@gmail.com
 */
public abstract class BaseObject {
    private double x,y,radius;
    private boolean isAlive;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.isAlive = true;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void draw () {
    }

    public void move () {

    }

    public void die () {
        isAlive = false;
    }

    public boolean isIntersect(BaseObject o) {
        //дистанция_между_объектами < max (радиус_первого_объекта, радиус_второго_объекта).

        double deltaX = x - o.x;
        double deltaY = y - o.y;
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        return distance <= Math.max (radius, o.getRadius());
    }
}
