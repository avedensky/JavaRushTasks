package com.javarush.task.task18.task1819;

/* 
Объединение файлов

Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    static final int BUF_SIZE = 1024; //Размер буффера для чтения
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        fileToMem (mem, fileName2);
        fileToMem (mem, fileName1);
        FileOutputStream f = new FileOutputStream(fileName1);
        mem.writeTo(f);
        f.close();
    }

    public static void fileToMem(ByteArrayOutputStream mem, String fileName) throws IOException {
        FileInputStream f = new FileInputStream(fileName);
        int readedByte = 0;
        while (f.available() > 0) {
            byte[] buf = new byte[Solution.BUF_SIZE];
            readedByte = f.read(buf);
            mem.write(buf, 0, readedByte);
        }
        f.close();
    }
}
