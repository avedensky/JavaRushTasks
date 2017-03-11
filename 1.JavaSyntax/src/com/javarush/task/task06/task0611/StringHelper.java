package com.javarush.task.task06.task0611;

/* 
Класс StringHelper
*/

public class StringHelper {
    public static String multiply(String s) {
        String result = "";
        //напишите тут ваш код
        for (int i=0;i<5;i++)
            result +=s;
        return result;
    }

    public static String multiply(String s, int count) {
        String result = "";
        //напишите тут ваш код
        for (int i=0;i<count;i++)
            result +=s;

        return result;
    }

    public static void main(String[] args) {

    }
}
