package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {
        // find minimum here — найти минимум тут
        int min = array.get(0).intValue();
        for (int i=1;i<array.size();i++)
            if (array.get(i).intValue() < min)
                min = array.get(i).intValue();
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException {
        //create and initialize a list here - создать и заполнить список тут
        ArrayList<Integer> lst = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i=0;i<n;i++)
            lst.add(Integer.parseInt(sc.nextLine()));

        return lst;
    }
}
