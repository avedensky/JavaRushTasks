package com.javarush.task.task18.task1808;

/* 
Разделение файла

Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String fileName1 = scan.nextLine();
        String fileName2 = scan.nextLine();
        String fileName3 = scan.nextLine();

        FileInputStream f1 = new FileInputStream(fileName1);
        FileOutputStream f2 = new FileOutputStream(fileName2);
        FileOutputStream f3 = new FileOutputStream(fileName3);

        int fileSize = f1.available();
        int part1Size = fileSize % 2 == 0 ? fileSize / 2 : fileSize / 2 + 1;

        while (f1.available() > 0) {
            byte[] buf1 = new byte [part1Size];
            byte[] buf2 = new byte [fileSize - part1Size];

            f1.read(buf1);
            f1.read(buf2);
            f2.write(buf1);
            f3.write(buf2);
        }
        f1.close ();
        f2.close ();
        f3.close ();
    }
}
