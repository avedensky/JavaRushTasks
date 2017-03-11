package com.javarush.task.task09.task0921;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList <Integer> lst = new ArrayList<>();
        try {
            while (true) {
                lst.add(Integer.parseInt(br.readLine()));
            }
        } catch (Exception e) {
            for (Integer i : lst) {
                System.out.println(i);
            }
        }
    }
}
