package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if (x==0 || y==0)
            return;

        if (x>0 && y>0)
            System.out.println(1);

        if (x<0 && y>0)
            System.out.println(2);

        if (x<0 && y<0)
            System.out.println(3);

        if (x>0 && y<0)
            System.out.println(4);
    }
}
