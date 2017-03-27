package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Продвинутый поиск файлов

Давай реализуем настраиваемый поиск файлов в директории.
Просмотри интерфейс java.nio.file.FileVisitor и его базовую реализацию java.nio.file.SimpleFileVisitor.
Во время поиска по дереву файлов с помощью метода Files.walkFileTree(Path start, FileVisitor<? super Path> visitor)
мы используем объект FileVisitor для выполнения необходимых операций над найденными объектами и.

Наш класс для поиска будет называться SearchFileVisitor и расширять SimpleFileVisitor.

Поиск можно будет выполнять по таким критериям:
— выражение, встречающееся в названии файла (String);
— выражение, встречающееся в содержимом файла (String);
— максимальный и минимальный размер файла (int).
Можно задавать либо один, либо сразу несколько критериев для поиска.

Я в main написал код, который использует готовый SearchFileVisitor для поиска файлов, тебе осталась совсем легкая задача — выполнить его реализацию.
Подсказка 1: методы get… , set… — это геттеры и сеттеры полей. Основная логика класса по поиску выполняется в методе visitFile(Path file, BasicFileAttributes attrs).
Подсказка 2: для работы с файлами используй только классы из пакета java.nio.
*/

//И снова человеческий разум победил валидатор...
public class Solution {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName("amigo");
        searchFileVisitor.setPartOfContent("programmer");
        searchFileVisitor.setMinSize(1);
        searchFileVisitor.setMaxSize(300);

        Files.walkFileTree(Paths.get("E:\\tmp\\1"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }

}
