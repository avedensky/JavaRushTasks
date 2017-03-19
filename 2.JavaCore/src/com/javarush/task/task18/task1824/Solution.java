package com.javarush.task.task18.task1824;

/* 
Файлы и исключения

Читайте с консоли имена файлов.
Если файла не существует (передано неправильное имя файла), то перехватить исключение FileNotFoundException,
вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки.
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = null;

        while (true) {
            String fileName = conReader.readLine();
            try {
                file = new FileInputStream(fileName);
                file.close();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                conReader.close();
                return;
            }
        }
    }
}
