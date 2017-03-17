package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.*;

/* 
Сортировка байт

Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений — отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Валидатор: В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in);
        String filename = reader.nextLine();

        FileInputStream f = new FileInputStream(filename);
        TreeSet<Integer> setSortBytes = new TreeSet<>();

        //read from file
        while (f.available() > 0) {
            setSortBytes.add(f.read());
        }

        f.close();

        //Выводим
        for (int value : setSortBytes)
            System.out.print(value + " ");
    }
}
