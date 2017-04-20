package com.javarush.task.task39.task3907.workers;

public class NormalWorker implements Worker, Sleeper, Eater {
    @Override
    public void work() {
        System.out.println("NormalWorker is working!");
    }

    @Override
    public void eat() {
        System.out.println("NormalWorker is eating!");
    }

    @Override
    public void sleep() {
        System.out.println("NormalWorker is sleeping!");
    }
}
