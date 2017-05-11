package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Alexey on 11.05.2017.
 */

//2. В классе ConsoleHelper реализуй логику статического метода Operation askOperation().
//        Спросить у пользователя операцию.
//        Если пользователь вводит 1, то выбирается команда INFO, 2 — DEPOSIT, 3 — WITHDRAW, 4 — EXIT;
//        Используйте метод, описанный в п.1.
//        Обработай исключение — запроси данные об операции повторно.

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);

    }

    public static String readString() throws IOException {
        String line = bis.readLine();
        return line;
    }

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

    public static Operation askOperation(){
        do {
            writeMessage("Choice operation:\n1) INFO\n2) DEPOSIT\n3) WITHDRAW\n4) EXIT");
            try {
                int choice = Integer.parseInt(readString());
                return Operation.getAllowableOperationByOrdinal(choice);
            } catch (IllegalArgumentException e) {
                writeMessage("You input wrong! Try Again.");
                continue;
            } catch (IOException e) {
                writeMessage("You input wrong! Try Again.");
                continue;
            }
        } while (true);
    }

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
