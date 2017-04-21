package com.javarush.task.task28.task2810.model;

/**
 * Created by Alexey on 21.04.2017.
 */
public class Provider {
    Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
