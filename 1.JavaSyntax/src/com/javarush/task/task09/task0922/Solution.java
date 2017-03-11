package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        Date dt = new Date (s);
        //08/18/2013
        //AUG 18, 2013
        SimpleDateFormat format =  new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        String DateToStr = format.format(dt);
        System.out.println(DateToStr.toUpperCase());


    }
}
