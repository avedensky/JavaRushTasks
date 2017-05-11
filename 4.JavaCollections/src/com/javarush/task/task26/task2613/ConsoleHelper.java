package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alexey on 11.05.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);

    }

    public static String readString() throws IOException {
        String line = bis.readLine();
        return line;
    }


    //    2. Чтобы считать код валюты, добавим статический метод String askCurrencyCode() в ConsoleHelper.
//    Этот метод должен предлагать пользователю ввести код валюты, проверять, что код содержит 3 символа.
//    Если данные некорректны, то сообщить об этом пользователю и повторить.
//    Если данные валидны, то перевести код в верхний регистр и вернуть.
    public static String askCurrencyCode() throws IOException {
        {
            String code = null;
            writeMessage("Please choice currency code:");
            while (true) {
                code = readString();
                if (code.length() == 3)
                    break;
                else
                    writeMessage("Error, Please choice again:");

            }
            return code.toUpperCase();
        }
    }

//    3. Чтобы считать номинал и количество банкнот, добавим статический метод String[] getValidTwoDigits(String currencyCode) в ConsoleHelper.
//    Этот метод должен предлагать пользователю ввести два целых положительных числа.
//    Первое число — номинал, второе — количество банкнот.
//    Никаких валидаторов на номинал нет. Т.е. 1200 — это нормальный номинал.
//    Если данные некорректны, то сообщить об этом пользователю и повторить.

    public static String[] getValidTwoDigits(String currencyCode) throws IOException {
        writeMessage("Input nominal and total:");

        String[] input;
        while (true) {
            input = readString().split(" ");

            int nominal = 0;
            int total = 0;
            try {
                nominal = Integer.parseInt(input[0]);
                total = Integer.parseInt(input[1]);
            } catch (Exception e) {
                writeMessage("Error, Repeat again:");
                continue;
            }
            if (nominal <= 0 || total <= 0) {
                writeMessage("Error, Repeat again:");
                continue;
            }
            break;
        }
        return input;
    }

}
