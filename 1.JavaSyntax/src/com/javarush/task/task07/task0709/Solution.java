package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        ArrayList<String> list = new ArrayList<String>();

        Scanner sc = new Scanner(System.in);

        int str_min_len = -1;
        String tmp;
        int tmp_len = 0;

        for (int i=0; i<5;i++) {
            tmp = sc.nextLine();
            tmp_len = tmp.length();

            if (tmp_len < str_min_len || str_min_len == -1)
                str_min_len = tmp_len;

            list.add(tmp);
        }

        for (int i= 0; i<list.size();i++) {
            if (list.get(i).length() == str_min_len)
                System.out.println(list.get(i));
        }
    }
}
