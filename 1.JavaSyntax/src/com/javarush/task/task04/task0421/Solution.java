package com.javarush.task.task04.task0421;

/* 
Настя или Настя?
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        if (str1.equals(str2))
            System.out.println("Имена идентичны");
        else
            if (str1.length()==str2.length())
                System.out.println("Длины имен равны");
    }
}
