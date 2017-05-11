package com.javarush.task.task26.task2613;

import java.util.Map;

/**
 * Created by Alexey on 11.05.2017.
 */
public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
}
