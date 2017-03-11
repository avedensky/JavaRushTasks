package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int otric=0;
        int polog=0;
        for (int i=0;i<3;i++) {
            int a = Integer.parseInt(br.readLine());
            if (a<0)
                otric += 1;
            if (a>0)
                polog += 1;

        }

        System.out.println("количество отрицательных чисел: "+otric);
        System.out.println("количество положительных чисел: "+polog);

    }
}
