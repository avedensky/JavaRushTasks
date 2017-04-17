package com.javarush.task.task37.task3714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Древний Рим

Амиго, привет! Я недавно увлекся историей вашей планеты и меня заинтересовал период Древнего Рима.
Интересно тогда было жить, сплошные развлечения и вино! Или рабство, если не повезло со стартовой локацией…

В общем, мне нужен метод romanToInteger, который будет конвертировать число в римской системе
счисления {I, V, X, L, C, D, M} в десятичную. Иначе никак не разобрать что и когда у них происходило.


Требования:
1. Метод romanToInteger должен конвертировать число в римской системе счисления в десятичную.
2. Метод romanToInteger должен возвращать значение типа int и принимать один параметр типа String.
3. Метод romanToInteger должен быть публичным.
4. Метод romanToInteger должен быть статическим.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        StringBuffer sbuf = new StringBuffer(s.trim());

        Map<Integer, String> patterns = new LinkedHashMap<>();
        patterns.put(3000, "MMM");
        patterns.put(2000, "MM");
        patterns.put(900, "CM");
        patterns.put(1000, "M");
        patterns.put(800, "DCCC");
        patterns.put(700, "DCC");
        patterns.put(600, "DC");
        patterns.put(400, "CD");
        patterns.put(500, "D");
        patterns.put(300, "CCC");
        patterns.put(200, "CC");
        patterns.put(90, "XC");
        patterns.put(100, "C");
        patterns.put(80, "LXXX");
        patterns.put(70, "LXX");
        patterns.put(60, "LX");
        patterns.put(40, "XL");
        patterns.put(50, "L");
        patterns.put(30, "XXX");
        patterns.put(20, "XX");
        patterns.put(9, "IX");
        patterns.put(10, "X");
        patterns.put(8, "VIII");
        patterns.put(7, "VII");
        patterns.put(6, "VI");
        patterns.put(4, "IV");
        patterns.put(5, "V");
        patterns.put(3, "III");
        patterns.put(2, "II");
        patterns.put(1, "I");

        //Find Patterns
        int sum = 0;
        for (Map.Entry<Integer, String> pair : patterns.entrySet()) {
            int pos = sbuf.indexOf(pair.getValue());
            if (pos >= 0) {
                sum += pair.getKey();
                sbuf.delete(pos, pos + pair.getValue().length());
            }
        }
        return sum;
    }
}

