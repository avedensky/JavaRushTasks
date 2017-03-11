package com.javarush.task.task03.task0322;


/* 
Большая и чистая
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));

        String name1 = br.readLine();
        String name2 = br.readLine();
        String name3 = br.readLine();


        //Вася + Ева + Анжелика = Чистая любовь, да-да!
        System.out.println(name1+" + "+name2+" + "+name3+" = Чистая любовь, да-да!");
    }
}