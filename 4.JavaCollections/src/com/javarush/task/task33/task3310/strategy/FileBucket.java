package com.javarush.task.task33.task3310.strategy;

/*
9.1. Создай класс FileBucket в пакете strategy.
9.2. Добавь в класс поле Path path. Это будет путь к файлу.
9.3. Добавь в класс конструктор без параметров, он должен:
9.3.1. Инициализировать path временным файлом. Файл должен быть размещен в директории для временных файлов и иметь случайное имя.

Подсказка: Files.createTempFile.

9.3.2. Создавать новый файл, используя path. Если такой файл уже есть, то заменять его.
9.3.3. Обеспечивать удаление файла при выходе из программы.

Подсказка: deleteOnExit().

9.4. Добавь в класс методы:
9.4.1. long getFileSize(), он должен возвращать размер файла на который указывает path.
9.4.2. void putEntry(Entry entry) — должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.
9.4.3. Entry getEntry() — должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.
9.4.4. void remove() – удалять файл на который указывает path.
Конструктор и методы не должны кидать исключения.
 */


import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Alexey Vedensky on 15.04.2017.
 * MAIL: avedensky@gmail.com
 */

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        try {
            return Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void putEntry(Entry entry) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(entry);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Entry getEntry() {
        Entry entry = null;

        if (getFileSize() <= 0)
            return entry;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            entry = (Entry) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
