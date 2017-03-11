package com.javarush.task.task04.task0422;

/* 
18+
*/

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
        String name = br.readLine();
        int age = Integer.parseInt(br.readLine());

        if (age<18)
            System.out.println("Подрасти еще");
    }
}
