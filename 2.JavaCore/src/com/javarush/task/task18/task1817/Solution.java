package com.javarush.task.task18.task1817;

/* 
Пробелы

В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.
*/

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader f = new FileReader(args[0]);

        int spaceCount = 0;
        int charCount = 0;
        while (f.ready()) {
            char ch = (char) f.read();
            charCount++;

            if (ch == ' ')
                spaceCount++;

        }

        f.close();

        System.out.println(String.format("%.2f", ((float) spaceCount / charCount) * 100));


    }
}
