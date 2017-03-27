package com.javarush.task.task31.task3103;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/* 
Своя реализация

Реализуй логику методов:
1. readBytes — должен возвращать все байты файла fileName.
2. readLines — должен возвращать все строки файла fileName. Используй кодировку по умолчанию.
3. writeBytes — должен записывать массив bytes в файл fileName.
4. copy — должен копировать файл resourceFileName на место destinationFileName.

ГЛАВНОЕ УСЛОВИЕ:
Никаких других импортов!
*/
public class Solution {
    public static byte[] readBytes(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get (fileName));
    }

    public static List<String> readLines(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.write(Paths.get(fileName), bytes);
    }

    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName));
    }
}
