package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.IOException;

/**
 * Created by Alexey on 11.05.2017.
 */

//В классе DepositCommand в методе execute() запроси код валюты,
//потом запроси номинал и количество банкнот, а потом добавь их в манипулятор.
//Если номинал и количество банкнот пользователь ввел не правильно(не числа) -
//повторять попытку по введению номинала и количества банкнот.
class DepositCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        String currencyCode = null;
        try {
            currencyCode = ConsoleHelper.askCurrencyCode();
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            String[] s = ConsoleHelper.getValidTwoDigits(currencyCode);
            int nominal = Integer.parseInt(s[0]);
            int total = Integer.parseInt(s[1]);
            currencyManipulator.addAmount(nominal, total);
        } catch (NumberFormatException e) {
            ConsoleHelper.writeMessage("Error");
        }

    }

}
