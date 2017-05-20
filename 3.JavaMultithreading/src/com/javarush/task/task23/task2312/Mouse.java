package com.javarush.task.task23.task2312;

/**
 * Created by Alex Vedensky on 17.05.2017.
 * MAIL: avedensky@gmail.com
 */


//Надо написать и реализовать метод createMouse() в классе Room.
//
//        В этом методе мы просто должны создавать новую мышь со случайными координатами в комнате.
//
//        Как получить случайные координаты?
//
//        Это ты уже должен был знать. На всякий случай даю подсказку:
//
//        int x = (int) (Math.random() * width);
//
//        Еще понадобится метод - eatMouse(), на случай, если мышь все-таки кто-то съест :)
//
//        Пока сложной логики в этом методе не будет - просто будем вызывать метод createMouse и все.
public class Mouse {
    private int x, y;

    public Mouse(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
