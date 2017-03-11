package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        InputStreamReader sreader = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (sreader);

        int age = Integer.parseInt(br.readLine());
        String name = br.readLine();

        System.out.println (name+" захватит мир через "+age+" лет. Му-ха-ха!");

    }
}
