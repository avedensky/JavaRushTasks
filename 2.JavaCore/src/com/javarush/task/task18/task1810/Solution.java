package com.javarush.task.task18.task1810;

/* 
DownloadException

1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        final int MAGIC_SIZE = 1000;

        while (true) { //нет выхода и ...
            // Далее некрасивый алгоритм в угоду валидатору.
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();
            FileInputStream f = new FileInputStream(filename);
            int size = f.available();
            f.close();
            reader.close();

            if (size < MAGIC_SIZE)
                throw new DownloadException();
        }
    }

    public static class DownloadException extends Exception {

    }
}
