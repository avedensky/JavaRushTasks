package com.javarush.task.task19.task1920;

/* 
Самый богатый

В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
String.

Для каждого имени посчитать сумму всех его значений.
Вывести в консоль имена в алфавитном порядке, у которых максимальная сумма.
Имена разделять пробелом либо выводить с новой строки.
Закрыть потоки.

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров


Валидатор задачу не пропускает:
Программа должна выводить в консоль имена, у которых максимальная сумма.


На файлах в кодировке UTF-8 без BOM все отрабатавает как надо.
Но если сделать кодировку UTF-8 (c BOM), то у визуально одинаковых строк - будет разный hashcode.
А так как сравнение у map построено на хэш коде, появляются дупликаты в map. И может быть валидатор
проверяет данные на основе своего файла в этой кодировке (c BOM) и - поэтому не проходит...
Но чтобы проверить это - лучше читать в байтах, а валидатор ругается если применить не FileReader. Вот ведь...

Тестовый файл:
Петров 0.85
Петров 0.85
Петров 0.6332
Петров 0.6332
Петров 0.6332
Иванов 1.35
Сидоров 1.2
Эльман 3.5995999999999997
Сидоров 0.85

Вывод:
Петров
Эльман
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        TreeMap<String, Double> map = new TreeMap<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        double max = Double.MIN_VALUE;
        while (fileReader.ready()) {
            String s = fileReader.readLine();
            String[] strs = s.split("[\\s\\t\\n\\x0B\\f\\r]");
            String key = strs[0];
            double value = Double.parseDouble(strs[1]);
            if (map.containsKey(key)) {
                map.put(key, map.get(strs[0]) + value);
            } else
                map.put(key, value);
        }
        fileReader.close();

        //Max
        for (Double a : map.values())
            if (max < a)
                max = a;

        //show
        for (Map.Entry<String, Double> pair : map.entrySet())
            if (pair.getValue().equals(max))
                System.out.println(pair.getKey());
    }
}
