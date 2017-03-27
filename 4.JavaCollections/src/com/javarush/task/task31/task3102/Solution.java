package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы

Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();
        Stack<File> files = new Stack<>();

        files.push(new File(root));
        while (!files.empty()) {
            File current = files.pop();

            if (current.isDirectory()) {
                //File[] tmp = current.listFiles();
                for (File f : current.listFiles())
                    files.push(f);
            }
            if (current.isFile())
                result.add(current.getAbsolutePath());
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        List<String> fileList = getFileTree("e:\\tmp");
        for (String filePath : fileList)
            System.out.println(filePath);

    }
}
