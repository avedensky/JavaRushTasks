package com.javarush.task.task21.task2110;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* 
Рефакторинг методов

Отрефакторите метод writeZipEntriesToFile в соответствии с java7 try-with-resources.


Требования:
1. Метод writeZipEntriesToFile должен быть объявлен с модификатором доступа public.
2. Метод writeZipEntriesToFile должен быть статическим.
3. Тип возвращаемого значения метода writeZipEntriesToFile должен быть void.
4. Метод writeZipEntriesToFile должен корректно использовать try-with-resources. В программе не должно быть закомментированного кода.
*/
public class Solution {
    public static void writeZipEntriesToFile(String zipFileName, String outputFileName) {
        Charset charset = StandardCharsets.UTF_8;
        Path outputFilePath = Paths.get(outputFileName);

        try {
            try (
                    ZipFile zip = new ZipFile(zipFileName);
                    BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset);
            ) {

                String newLine = System.getProperty("line.separator");
                for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                    // Берем имя файла из архива и записываем его в результирующий файл
                    // Get the entry name and write it to the output file
                    String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
                    writer.write(zipEntryName, 0, zipEntryName.length());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
