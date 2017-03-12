package com.javarush.task.task14.task1421;

/**
 * Created by Alexey on 12.03.2017.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton (){
        this.instance = this;
    }

    public static Singleton getInstance () {
        if (instance == null)
            new Singleton();
        return instance;
    }
}
