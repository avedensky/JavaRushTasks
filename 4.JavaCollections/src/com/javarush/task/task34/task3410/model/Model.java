package com.javarush.task.task34.task3410.model;

import com.javarush.task.task34.task3410.controller.EventListener;
/**
 * Created by Alexey on 14.05.2017.
 */
public class Model {
    public static int FIELD_CELL_SIZE = 20;
    private EventListener eventListener;

    public void setEventListener(EventListener eventListener) {
        this.eventListener = eventListener;
    }

}
