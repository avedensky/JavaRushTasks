package com.javarush.task.task19.task1906;

/* 
Четные байты

Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.

Пример:
второй байт, четвертый байт, шестой байт и т.д.

Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = conReader.readLine();
        String fileName2 = conReader.readLine();
        conReader.close();


        FileReader fileReader = new FileReader(fileName1);
        FileWriter fileWriter = new FileWriter(fileName2);

        int i=1;
        while (fileReader.ready()) {
            int value = fileReader.read();
            if (i % 2 == 0)
                fileWriter.write(value);
            i++;
        }
        fileReader.close();
        fileWriter.close();

    }
}
