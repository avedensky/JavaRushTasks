package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        BufferedReader conReader = new BufferedReader(new InputStreamReader (System.in));
        ArrayList<Integer> vect = new ArrayList<>();

        try {
            BufferedReader fileReader = new BufferedReader((new InputStreamReader(new FileInputStream(conReader.readLine()))));

            while (fileReader.ready()) {
                vect.add(Integer.parseInt(fileReader.readLine()));
            }
            fileReader.close();
        }catch (FileNotFoundException e){
            System.out.println("File Not Found!");
        } catch (IOException e) {
            System.out.println("Can't read File");
        }

        Collections.sort (vect);

        for (Integer i : vect) {
            if (i % 2 == 0)
                System.out.println(i);
        }



    }
}
