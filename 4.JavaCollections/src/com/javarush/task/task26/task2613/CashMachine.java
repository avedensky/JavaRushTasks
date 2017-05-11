package com.javarush.task.task26.task2613;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Alexey on 11.05.2017.
 */

enum Operation {INFO, DEPOSIT, WITHDRAW, EXIT}

//1. Выберем операцию, с которой мы сможем начать.
//Подумаем. В банкомате еще денег нет, поэтому INFO и WITHDRAW протестить не получится.
//Начнем с операции DEPOSIT — поместить деньги.
//Считаем с консоли код валюты, потом считаем номинал и количество банкнот,
// а потом добавим их в манипулятор.

//
//5. Пора уже увидеть приложение в действии.
//В методе main захардкодь логику пункта 1.
//Кстати, чтобы не было проблем с тестами на стороне сервера, добавь в метод main первой
// строчкой Locale.setDefault(Locale.ENGLISH);
//Запускаем, дебажим, смотрим.

//Метод main класса CashMachine должен считывать с консоли код валюты, потом считывать номинал
// и количество банкнот, а потом добавлять их в манипулятор.
//
public class CashMachine {
    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        CurrencyManipulator currencyManipulator;

        String code = ConsoleHelper.askCurrencyCode();
        String[] strs = ConsoleHelper.getValidTwoDigits(code);
        currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        currencyManipulator.addAmount(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
    }
}
