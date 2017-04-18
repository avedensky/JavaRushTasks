package com.javarush.task.task38.task3806;

/* 
Улучшения в Java 7 (try-with-resources)

Перепиши реализации методов класса Solution.
Используй нововведения (try-with-resources), касающиеся обработки исключений, которые были добавлены в Java 7.


Требования:
1. В методе printFile1 не должно быть catch блоков.
2. В методе printFile2 не должно быть catch блоков.
3. В методе printFile1 FileInputStream должен быть инициализирован как ресурс в блоке try.
4. В методе printFile2 BufferedInputStream должен быть инициализирован как ресурс в блоке try.
5. В методе printFile2 FileInputStream должен быть инициализирован как ресурс в блоке try.
6. В методе printFile2 должен быть только один блок try.
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public void printFile1() throws IOException {
        //FileInputStream fileInputStream = null;

        try (FileInputStream fileInputStream = new FileInputStream("file.txt")) {
            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = fileInputStream.read();
            }
        }
    }

    public void printFile2() throws IOException {
        // FileInputStream fileInputStream = null;
        // BufferedInputStream bufferedInputStream = null;
        try (
                FileInputStream fileInputStream = new FileInputStream("file.txt");
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ) {
            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = bufferedInputStream.read();
            }
        }
    }

    public static void main(String[] args) {

    }
}