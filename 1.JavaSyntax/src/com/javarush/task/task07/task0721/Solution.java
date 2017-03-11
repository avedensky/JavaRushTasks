package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

       int[] vect = new int[20];

        //напишите тут ваш код
        for (int i=0;i<20;i++){
            vect[i] = Integer.parseInt(reader.readLine());
        }

        maximum = vect[0];
        minimum = vect[0];
        for (int i=0;i<vect.length;i++){
            if (vect[i] > maximum)
                maximum = vect[i];
            if (vect[i] < minimum)
                minimum = vect[i];
        }

        System.out.println(maximum+" "+minimum);
    }
}
