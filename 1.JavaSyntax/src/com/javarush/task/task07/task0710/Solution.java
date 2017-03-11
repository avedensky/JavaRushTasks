package com.javarush.task.task07.task0710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
В начало списка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        ArrayList<String> list = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < 10; i++) {
            list.add(0, sc.nextLine());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
    }
}
