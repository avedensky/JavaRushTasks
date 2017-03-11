package com.javarush.task.task07.task0719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Вывести числа в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<Integer> lst= new ArrayList<>();

        for (int i=0;i<10;i++) {
            lst.add(Integer.parseInt(reader.readLine()));
        }
        for (int i=lst.size()-1;i>=0;i--) {
            System.out.println(lst.get(i));
        }
    }
}
