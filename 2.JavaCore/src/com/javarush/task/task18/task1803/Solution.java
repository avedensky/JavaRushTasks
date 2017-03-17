package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.*;


/*
Самые частые байты

Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.
 */

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        String filename = reader.nextLine();

        FileInputStream f = new FileInputStream(filename);

        HashMap<Integer, Integer> mapOfByte = new HashMap<Integer, Integer>();

        int value = 0;
        Integer count = 0;
        while (f.available() > 0) {
            value = f.read();

            count = mapOfByte.get(value);
            if (count != null)
                count++;
            else
                count = 0;

            mapOfByte.put(value, count);
        }

        f.close();


        /*
        Из-за этой строчки:
        int max = Collections.max(mapOfByte.values());

        Валидатором не принимается, показывая странные ошибки:

        - Для чтения из файла используй поток FileInputStream.
        - В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
        - Поток чтения из файла должен быть закрыт.

        Хотя условия выполненны, используется FileInputStream, поток закрыт ранее, и данные через пробел...

        Пришлось городить велосипед, по поиску max
        */

        //Находим максимальное число повторений
        boolean first = true;
        int max = 0;
        for (int amountByte : mapOfByte.values()) {
            if (first) {
                max = amountByte;
                first = false;
            }
            if (max < amountByte)
                max = amountByte;
        }

        //Выводим
        for (Map.Entry pair : mapOfByte.entrySet()) {
            if (max == (int) pair.getValue())
                System.out.print(" " + pair.getKey());
        }

    }
}