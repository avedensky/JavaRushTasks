package com.javarush.task.task31.task3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл

В метод main приходит список аргументов.
Первый аргумент — имя результирующего файла resultFileName, остальные аргументы — имена файлов fileNamePart.
Каждый файл (fileNamePart) — это кусочек zip архива. Нужно разархивировать целый файл, собрав его из кусочков.
Записать разархивированный файл в resultFileName.
Архив внутри может содержать файл большой длины, например, 50Mb.
Внутри архива может содержаться файл с любым именем.

Пример входных данных. Внутри архива находится один файл с именем abc.mp3:
C:/result.mp3
C:/pathToTest/test.zip.003
C:/pathToTest/test.zip.001
C:/pathToTest/test.zip.004
C:/pathToTest/test.zip.002


E:/result.mp3 E:/test.zip.003 E:/test.zip.001 E:/test.zip.004 E:/test.zip.002
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        // Это решение позаимствовано отсюда
        // https://www.snip2code.com/Snippet/1178691/Level-31--Lesson-06--Bonus-01

        String resultFileName = args[0];
        int filePartCount = args.length - 1;
        String[] fileNamePart = new String[filePartCount];
        for (int i = 0; i < filePartCount; i++) {
            fileNamePart[i] = args[i + 1];
        }
        Arrays.sort(fileNamePart);

        List<FileInputStream> fisList = new ArrayList<>();
        for (int i = 0; i < filePartCount; i++) {
            fisList.add(new FileInputStream(fileNamePart[i]));
        }
        SequenceInputStream seqInStream = new SequenceInputStream(Collections.enumeration(fisList));
        ZipInputStream zipInStream = new ZipInputStream(seqInStream);
        FileOutputStream fileOutStream = new FileOutputStream(resultFileName);
        byte[] buf = new byte[1024 * 1024];
        while (zipInStream.getNextEntry() != null) {
            int count;
            while ((count = zipInStream.read(buf)) != -1) {
                fileOutStream.write(buf, 0, count);
            }
        }
        seqInStream.close();
        zipInStream.close();
        fileOutStream.close();
    }
/*
        //Мое работающее решение не принятое валидатором

        Path pathToResultFile = Paths.get (args[0]);
        Path pathToArchiveFile = Paths.get(pathToResultFile.toString() + ".zip");

        //Fill and sort list of part
        TreeSet <String> fileNamesParts = new TreeSet<>(new Sort());
        for (int i=1; i<args.length;i++)
            fileNamesParts.add(args[i]);

        //Create ZIP Archive
        if (Files.exists(pathToArchiveFile))
            Files.delete(pathToArchiveFile);
        Files.createFile(pathToArchiveFile);

        //Copy parts to Arhive
        for (String parts :fileNamesParts)
            Files.write(pathToArchiveFile, Files.readAllBytes(Paths.get(parts)), StandardOpenOption.APPEND);

        //Unzip
        ZipInputStream zip = new ZipInputStream(new FileInputStream(pathToArchiveFile.toFile()));
        ZipEntry zipEntry = zip.getNextEntry();
        if (zipEntry !=null)
            Files.copy(zip, pathToResultFile);

        zip.closeEntry();
        zip.close();
    }*/
}

class Sort implements Comparator<String> {
    public int compare(String a, String b) {
        int a1 = Integer.parseInt(a.substring(a.lastIndexOf(".") + 1));
        int b1 = Integer.parseInt(b.substring(b.lastIndexOf(".") + 1));
        return a.compareTo(b);
    }
}


//try (FileOutputStream reaultArchive = new FileOutputStream(resultFileName+".zip",true)) {
//}