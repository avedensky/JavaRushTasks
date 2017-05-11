package com.javarush.task.task26.task2613;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Alexey on 11.05.2017.
 */

// Такое решение не проходит
//enum Operation {
//    INFO, DEPOSIT, WITHDRAW, EXIT;
//
//    public static Operation getAllowableOperationByOrdinal(Integer i) throws IllegalArgumentException {
//        for (Operation o : Operation.values())
//            if (o.ordinal() == i)
//                return o;
//
//        throw new IllegalArgumentException();
//    }
//}

//A так работает...
enum Operation {
    INFO, DEPOSIT, WITHDRAW, EXIT;

    public static Operation getAllowableOperationByOrdinal(Integer i)
    {
        switch (i)
        {
            case 1:
                return INFO;
            case 2:
                return DEPOSIT;
            case 3:
                return WITHDRAW;
            case 4:
                return EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }
}



public class CashMachine {
    public static void main(String[] args) throws IOException {
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
