package com.javarush.task.task14.task1417;

/**
 * Created by Alexey on 12.03.2017.
 */
public class Hrivna extends Money {

    Hrivna (double d) {
        super (d);
    }

    @Override
    public String getCurrencyName() {
        return "HRN";
    }
}
