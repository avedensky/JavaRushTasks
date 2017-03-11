package com.javarush.task.task07.task0712;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++)
            list.add(reader.readLine());
        int minS = list.get(0).length(), maxS = minS;
        for (String s : list){
            if (s.length() > maxS)
                maxS = s.length();
            if (s.length() < minS)
                minS = s.length();
        }
        for (String s : list)
            if (s.length() == maxS || s.length() == minS){
                System.out.println(s);
                break;
            }
    }
}




//        Scanner sc = new Scanner(System.in);


//        list.add ("222222222");
//        list.add ("11111");
//        list.add ("3333333333344444444444443");
//        list.add ("44444444");
//        list.add ("55555");
//        list.add ("66");
//        list.add ("77");
//        list.add ("8888888888");
//        list.add ("999");
//        list.add ("000000000000000000000");

//        for (int i = 0; i < 10; i++) {
//            list.add(0, sc.nextLine());
//        }
//
//
//        int min = list.get(0).length();
//        int max = min;
//
//        for (String s : list){
//            if (s.length() > max)
//                max = s.length();
//
//            if (s.length() < min)
//                min = s.length();
//        }
//
//        for (String s : list)
//            if (s.length() == max || s.length() == min){
//                System.out.println(s);
//                break;
//            }
//
//    }
//}

//        int min=list.get(0).length();
//        int max=0;
//        int tmp_l=0;
//
//        int ind1 = 0;
//        int ind2 = 0;
//
//        for (int i = 0; i < list.size(); i++) {
//            tmp_l = list.get(i).length();
//            if (min > tmp_l) {
//                min = tmp_l;
//                ind1 = i;
//            }
//
//            if (max < tmp_l) {
//                max = tmp_l;
//                ind2 = i;
//            }
//        }
//
//        if (ind1 > ind2 ) {
//            System.out.println(list.get(ind2));
//            System.out.println(list.get(ind1));
//        } else {
//            System.out.println(list.get(ind1));
//            System.out.println(list.get(ind2));
//        }


//        for (int i = 0; i < list.size(); i++) {
//            if (min == list.get(i).length())
//                System.out.println(list.get(i));
//
//            if (max == list.get(i).length())
//                System.out.println(list.get(i));
//        }

