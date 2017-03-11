package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int max = Math.max(Math.max(a,b),c);
        int min = Math.min(Math.min(a,b),c);
//        System.out.println(max);
//        System.out.println(min);

        if (a==b && b==c && c==a) {
            System.out.println(a);
            return;
        }


        if (max == a && min == b) {
            System.out.println(c);
            return;
        }

        if (max == b && min == a) {
            System.out.println(c);
            return;
        }


        if (max == c && min == a) {
            System.out.println(b);
            return;
        }

        if (max == a && min == c) {
            System.out.println(b);
            return;
        }


        if (max == c && min == b) {
            System.out.println(a);
            return;
        }

        if (max == b && min == c) {
            System.out.println(a);
            return;
        }




    }
}
