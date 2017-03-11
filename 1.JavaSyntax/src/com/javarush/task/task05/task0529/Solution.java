package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inp = "";
        int sum = 0;
        int a = 0;

        while (!inp.equals("сумма")) {
            inp =  br.readLine();
            try {
                a = Integer.parseInt(inp);
                sum += a;
            } catch (NumberFormatException e) {
                continue;
            }
        }
        System.out.println(sum);

    }
}
