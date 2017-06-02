package com.javarush.task.task24.task2407;

/*
обратите внимание, как именно Mouse отличается от Cat
Этот класс - привычный для вас.
*/
public class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}
