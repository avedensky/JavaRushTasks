package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> all = new ArrayList<Integer>();
        ArrayList<Integer> listOther = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();

        int a=0;
        for (int i=0;i<20;i++) {
            a = Integer.parseInt(sc.nextLine());
            all.add(a);

            a = all.get (i);
            if (a % 3 == 0 && a % 2 == 0) {
                list2.add(a);
                list3.add(a);
                continue;
            }
            if (a % 2 == 0) {
                list2.add(a);
                continue;
            }
            if (a % 3 == 0) {
                list3.add(a);
                continue;
            }
            listOther.add(a);
        }

        printList(list3);
        printList(list2);
        printList(listOther);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer i : list)
            System.out.println(i);
    }
}