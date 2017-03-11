package com.javarush.task.task03.task0316;

/* 
Экранирование символов
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        String a = "It's Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"";
        String b = "It's Java string: \\\"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"";
        System.out.println(a);
        System.out.println(b);
//        System.out.println ("It\'s Windows path: \"C:\\Program Files\\Java\\jdk1.7.0\\bin\"");
//        System.out.println ("It\'s Java string: \"C:\\\\Program Files\\\\Java\\\\jdk1.7.0\\\\bin\\\"");

    }
}
