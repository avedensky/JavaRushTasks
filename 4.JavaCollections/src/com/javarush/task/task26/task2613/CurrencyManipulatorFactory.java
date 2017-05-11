package com.javarush.task.task26.task2613;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alexey on 11.05.2017.
 */
public final class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        CurrencyManipulator current = null;
        return current;
    }
}