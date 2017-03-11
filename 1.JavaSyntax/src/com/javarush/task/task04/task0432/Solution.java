package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = Integer.parseInt(br.readLine());


        int i=0;
        while (i<n) {
            System.out.println(s);
            i++;
        }


    }
}
