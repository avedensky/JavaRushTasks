package com.javarush.task.task18.task1809;

/* 
Реверс файла

Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = br.readLine();
        String fileName2 = br.readLine();

        FileInputStream f1 = new FileInputStream(fileName1);
        FileOutputStream f2 = new FileOutputStream(fileName2);

        while (f1.available() > 0) {
            byte[] buf = new byte[f1.available()];
            byte[] reverseBuf = new byte[buf.length];

            f1.read(buf);

            for (int i = buf.length - 1; i >= 0; i--)
                reverseBuf[buf.length - i - 1] = buf[i];

            f2.write(reverseBuf);
        }
        f1.close();
        f2.close();
        br.close();
    }
}
