package com.javarush.task.task19.task1907;

/* 
Считаем слово

Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = conReader.readLine();
        conReader.close();

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        int count = 0;
//        int index = 0;
        String word = "world";
        while (fileReader.ready()) {
            String line = fileReader.readLine();
            String[] words = line.toString().split("\\W");
            for (String s : words)
                if (s.equals(word))
                    count++;
//            while ((index = s.indexOf(word, index+1)) >= 0)
//                count++;
        }
        fileReader.close();

        System.out.println(count);
    }
}
