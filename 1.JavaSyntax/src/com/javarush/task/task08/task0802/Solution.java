package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String,String> hm = new HashMap<>();

        hm.put("арбуз","ягода");
        hm.put("банан","трава");
        hm.put("вишня","ягода");
        hm.put("груша","фрукт");
        hm.put("дыня","овощ");
        hm.put("ежевика","куст");
        hm.put("жень-шень","корень");
        hm.put("земляника","ягода");
        hm.put("ирис","цветок");
        hm.put("картофель","клубень");

        for (Map.Entry entry: hm.entrySet()) {
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }


    }
}
