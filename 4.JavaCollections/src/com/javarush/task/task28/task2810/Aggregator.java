package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;

/**
 * Created by Alexey on 21.04.2017.
 */
public class Aggregator {
    public static void main(String[] args) {
        Provider provider = new Provider(null);
        Controller controller = new Controller(provider);
        System.out.println(controller);

    }
}
