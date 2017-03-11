package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int [] vct = new int[5];

        for (int i=0;i<vct.length;i++) {
            vct[i] = Integer.parseInt(reader.readLine());
        }

        int tmp;
        for (int i=0;i<vct.length;i++)
            for (int j=i+1; j<vct.length; j++)
                if (vct[i]>vct[j]){
                    tmp = vct[i];
                    vct[i] = vct[j];
                    vct[j] = tmp;
                }


        for (int i=0; i<vct.length; i++) {
            System.out.println(vct[i]);
        }
    }
}
