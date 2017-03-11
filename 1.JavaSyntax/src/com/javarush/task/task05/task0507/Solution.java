package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        int count = 0;
        double sum = 0;
        while (i != -1) {
            i = Integer.parseInt(br.readLine());
            sum += i;
            count++;
        }
        double avg = (sum+1) / (count-1);
        System.out.println(avg);
    }
}
//1 2 2 4 5 -1

