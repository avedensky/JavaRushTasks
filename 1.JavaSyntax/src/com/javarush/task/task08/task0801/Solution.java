package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet hs = new HashSet<>();
        hs.add("арбуз");
        hs.add("банан");
        hs.add("вишня");
        hs.add("груша");
        hs.add("дыня");
        hs.add("ежевика");
        hs.add("жень-шень");
        hs.add("земляника");
        hs.add("ирис");
        hs.add("картофель");

        for (Object o:  hs) {
            System.out.println((String)o );
        }
    }
}
