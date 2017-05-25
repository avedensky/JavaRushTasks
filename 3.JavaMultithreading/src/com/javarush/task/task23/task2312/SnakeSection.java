package com.javarush.task.task23.task2312;

public class SnakeSection {
    private int x;
    private int y;


    public SnakeSection(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SnakeSection that = (SnakeSection) o;

        if (this.x != that.x) return false;
        if (this.y != that.y) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
