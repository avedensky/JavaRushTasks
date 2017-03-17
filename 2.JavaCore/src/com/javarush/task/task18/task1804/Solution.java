package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые редкие байты

Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
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


        //int min = Collections.min(mapOfByte.values());


        //Находим минимальное число повторений
        boolean first = true;
        int min = 0;
        for (int amountByte : mapOfByte.values()) {
            if (first) {
                min = amountByte;
                first = false;
            }
            if (min > amountByte)
                min = amountByte;
        }


        //Выводим
        for (Map.Entry pair : mapOfByte.entrySet()) {
            if (min == (int) pair.getValue())
                System.out.print(" " + pair.getKey());
        }

    }
}

