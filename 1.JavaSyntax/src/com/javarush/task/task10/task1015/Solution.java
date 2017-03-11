package com.javarush.task.task10.task1015;

import java.util.ArrayList;
import java.util.Random;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] arrStr = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            arrStr[i] = new ArrayList<String>();
            for (int j = 0; j < 10; j++) {
                arrStr[i].add("Строка номер:" + j);
            }
        }
        return arrStr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}