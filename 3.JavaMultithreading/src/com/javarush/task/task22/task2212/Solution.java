package com.javarush.task.task22.task2212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* 
Проверка номера телефона

Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с ‘+‘, то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков ‘—‘, которые не могут идти подряд
4) может содержать 1 пару скобок ‘(‘ и ‘)‘ , причем если она есть, то она расположена левее знаков ‘-‘
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false


Требования:
1. Метод checkTelNumber должен возвращать значение типа boolean.
2. Метод checkTelNumber должен быть публичным.
3. Метод checkTelNumber должен принимать один параметр типа String.
4. Метод checkTelNumber должен корректно проверять валидность номера телефона переданного ему в качестве параметра.
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {
        int totalDigit = telNumber.replaceAll("\\D", "").length();

        //Если строка содержит что-то кроме допустимых символов
        if (telNumber.replaceAll("[^0-9\\+\\(\\)\\-]", "").length() != telNumber.length())
            return false;

        //если номер начинается с ‘+‘ и длинна не 12 цифр
        if (telNumber.startsWith("+") && totalDigit != 12)
            return false;

        //если номер начинается с цифры или скобки и длинна не 10 цифр
        if (telNumber.startsWith("[0-9]\\(") && totalDigit != 10)
            return false;

//        int leftBracketPosition = -1;
//        int leftBracketCount = 0;
//        int rightBracketPosition = -1;
//        int rightBracketCount = 0;
//
//        for (int i = 0; i < telNumber.length(); i++) {
//            if (telNumber.charAt(i) == '(') {
//                leftBracketPosition = i;
//                leftBracketCount += 1;
//                //Если сначала идет закрывающая скобка
//                if (leftBracketPosition > rightBracketPosition) {
//                    System.out.println("Если сначала идет закрывающая скобка");
//                    return false;
//                }
//                //Если количество открывающих скобок больше чем 1
//                if (leftBracketCount > 1) {
//                    System.out.println("Если количество открывающих скобок больше чем 1");
//                    return false;
//                }
//            }
//            if (telNumber.charAt(i) == ')') {
//                rightBracketPosition = i;
//                rightBracketCount += 1;
//                //Если нет открывающей скобки
//                if (leftBracketPosition == -1) {
//                    System.out.println("Если нет открывающей скобки");
//                    return false;
//                }
//                //Если количество закрывающих скобок больше чем 1
//                if (rightBracketCount > 1) {
//                    System.out.println("Если количество закрывающих скобок больше чем 1");
//                    return false;
//                }
//
//            }
//        }
//
//        //Если только одна скобка присутствует
//        if ((rightBracketPosition >-1 && leftBracketPosition == -1) || (leftBracketPosition>-1 && rightBracketPosition == -1)) {
//            System.out.println("Если только одна скобка присутствует");
//            return false;
//        } else {
//            if (leftBracketPosition - rightBracketCount > 3) {
//                System.out.println("Если скобки отстоят дальше чем 3 позиции");
//                return false;
//            }
//        }


//        System.out.println(totalDigit);
//        if (telNumber.charAt(0) == '+') {
//            //System.out.println(telNumber.replaceAll("\\D", ""));
//        }
        return true;
    }

    public static void main(String[] args) {
        //System.out.println(checkTelNumber("+380501234567"));

        HashMap<String, Boolean> phones = new HashMap<>();
        phones.put("+380501234567", true);
        phones.put("+380501234567", true);
        phones.put("+38(050)1234567", true);
        phones.put("+38050123-45-67", true);
        phones.put("050123-4567", false);
        phones.put("+38)050(1234567", false);
        phones.put("+38(050)1-23-45-6-7", false);
        phones.put("050ххх4567", false);
        phones.put("050123456", false);
        phones.put("(0)501234567", false);

        for (Map.Entry<String, Boolean> pair : phones.entrySet()) {
//            System.out.println(pair.getKey());
            if (checkTelNumber(pair.getKey()) != pair.getValue())
                System.out.println("ERROR:Should be:" + pair.getValue() + " checkTelNumber:" + checkTelNumber(pair.getKey()) + " " + pair.getKey());
        }

    }
}
