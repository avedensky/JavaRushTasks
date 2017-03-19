package com.javarush.task.task18.task1818;

/* 
Два в одном

Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        reader.close();

        FileOutputStream f1 = new FileOutputStream(fileName1, true);
        FileInputStream f2 = new FileInputStream(fileName2);
        FileInputStream f3 = new FileInputStream(fileName3);

        //File2 write to File1
        while (f2.available()>0) {
            byte[] buf = new byte[f2.available()];
            f2.read(buf);
            f1.write(buf);
        }

        f2.close();

        //File3 append to File1
        while (f3.available()>0) {
            byte[] buf = new byte[f3.available()];
            f3.read(buf);
            f1.write(buf);
        }

        f3.close();
        f1.close();
    }
}
