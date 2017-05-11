package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Alexey on 11.05.2017.
 */


public class CashMachine {
    public static void main(String[] args) throws IOException {

        Operation operation;
        do {
            operation = ConsoleHelper.askOperation();
            CommandExecutor.execute(operation);
        } while (operation != Operation.EXIT);


//        Locale.setDefault(Locale.ENGLISH);
//        CurrencyManipulator currencyManipulator;
//
//        String code = ConsoleHelper.askCurrencyCode();
//        String[] strs = ConsoleHelper.getValidTwoDigits(code);
//        currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
//        currencyManipulator.addAmount(Integer.parseInt(strs[0]), Integer.parseInt(strs[1]));
//        System.out.println(currencyManipulator.getTotalAmount());
    }
}
