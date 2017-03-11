package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        ArrayList<String> lst = new ArrayList<>();

        int N = Integer.parseInt(reader.readLine());
        int M = Integer.parseInt(reader.readLine());

        for (int i=0; i<N; i++)
            lst.add(reader.readLine());

        for (int i=0; i<M; i++)
            lst.add (lst.get(i));

        for (int i=M-1; i>=0; i--)
            lst.remove (i);

        for (String s : lst)
            System.out.println(s);



    }
}
