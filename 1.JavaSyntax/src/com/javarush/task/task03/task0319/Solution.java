package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader br = new BufferedReader (new InputStreamReader (System.in));

        String name = br.readLine();
        int value1 = Integer.parseInt(br.readLine());
        int value2 = Integer.parseInt(br.readLine());
        System.out.println(name+" получает "+value1+" через "+value2+" лет.");
   }
}
