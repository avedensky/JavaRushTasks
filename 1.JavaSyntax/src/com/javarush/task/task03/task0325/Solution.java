package com.javarush.task.task03.task0325;

import java.io.*;

/* 
Финансовые ожидания
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sallary = Integer.parseInt(br.readLine());

        System.out.println("Я буду зарабатывать $"+sallary+" в час");
    }
}
