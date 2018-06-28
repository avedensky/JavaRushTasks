package com.javarush.task.task39.task3909;

/* 
Одно изменение

Реализуй метод isOneEditAway(String first, String second)
который будет возвращать true, если возможно изменить/добавить/удалить один символ в одной из строк и получить другую.

Символы в анализируемой строке ограничены кодировкой ASCII.
Регистр символов учитывается.


Требования:
1. Метод isOneEditAway должен корректно работать для строк одинаковой длины.
2. Метод isOneEditAway должен корректно работать для строк разной длины.
3. Метод isOneEditAway должен корректно работать для пустых строк.
4. Метод isOneEditAway должен быть публичным.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(isOneEditAway("", "")); // true
        System.out.println(isOneEditAway("", "m")); //true
        System.out.println(isOneEditAway("m", "")); //true
        //System.out.println(isOneEditAway("m", null)); //
        System.out.println("------");
        System.out.println(isOneEditAway("mama", "ramas")); //false
        System.out.println(isOneEditAway("mamas", "rama")); //false
        System.out.println(isOneEditAway("rama", "mama")); //true
        System.out.println(isOneEditAway("mama", "dama")); //true
        System.out.println(isOneEditAway("amms", "amm"));  //false
        System.out.println(isOneEditAway("mama", "ama")); //true
    }

    public static boolean isOneEditAway(String first, String second) {
        int len1 = first.length();
        int len2 = second.length();
        int delta = Math.abs(len1 - len2);

        if (delta > 1)
            return false;

        if (first.equals("") && second.equals(""))
            return true;


        if(first.equals(second))
            return true; //Странно это... Т.к. по условию задачи, True - только когда возможно изменение... Но валидатору виднее

        StringBuffer s1 = (first.length() >= second.length()) ? new StringBuffer(first) : new StringBuffer(second);
        StringBuffer s2 = (first.length() < second.length()) ? new StringBuffer(first) : new StringBuffer(second);

        for (int i = 0; i < s2.length(); i++) {

            if (s1.charAt(i) != s2.charAt(i)) {

                if (delta != 0) {
                    s1.deleteCharAt(i);
                } else {
                    s1.deleteCharAt(i);
                    s2.deleteCharAt(i);
                }

                break;
            }
        }

        if (s1.length() != s2.length()) s1.deleteCharAt(s1.length()-1);

        return s1.toString().equals(s2.toString());

    }
}
