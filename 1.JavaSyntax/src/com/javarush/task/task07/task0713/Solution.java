package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/* 
Играем в Jолушку

Играем в Jолушку
1. Введи с клавиатуры 20 чисел, сохрани их в список и рассортируй по трём другим спискам:
Число нацело делится на 3 (x%3==0), нацело делится на 2 (x%2==0) и все остальные.
Числа, которые делятся на 3 и на 2 одновременно, например 6, попадают в оба списка.
2. Метод printList должен выводить на экран все элементы списка с новой строки.
3. Используя метод printList выведи эти три списка на экран. Сначала тот, который для x%3, потом тот, который для x%2, потом последний.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<Integer> all = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> listOther = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Random rnd = new Random(100);
        for (int i = 0; i < 20; i++)
            all.add(Integer.parseInt(reader.readLine()));// = Integer.parseInt(reader.readLine());//rnd.nextInt(100);
        reader.close();

        for(int i = 0;i < 20;i++){
            if(all.get(i)%3 == 0 && all.get(i)%2 ==0){
                list3.add(all.get(i));
                list2.add(all.get(i));
            }
            else if (all.get(i)%3 == 0){
                list3.add(all.get(i));
            }
            else if(all.get(i)%2 == 0){
                list2.add(all.get(i));
            }
            else {
                listOther.add(all.get(i));
            }
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