package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList <String> list =new ArrayList<>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");

        list.add(1,"именно");
        list.add(3,"именно");
        list.add("именно");

        for (String item : list) {
            System.out.println(item);
        }


    }
}
