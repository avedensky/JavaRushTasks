package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < 5; i++) {
            list.add(sc.nextLine());
        }

        String tmp;
        for (int i = 0; i < 13; i++) {
            tmp = list.get(list.size()-1);
            list.add(0,tmp);
            list.remove(list.size()-1);
        }



        for (int i = 0; i < 5; i++) {
            System.out.println(list.get(i));
        }
    }
}
