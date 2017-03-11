package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        BufferedWriter file = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));

        String s = "";
        while (!s.equals("exit")) {
            s = reader.readLine();
            file.write(s);
            file.newLine();
        }

        file.close();
        reader.close();
    }
}
