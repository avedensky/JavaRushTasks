package com.javarush.task.task12.task1207;

/* 
print(int) и print(Integer)
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.
*/

public class Solution {
    public static void main(String[] args) {
        print(10);
        print(new Integer(20));

    }

    //Напишите тут ваши методы
    public static void print (int a) {
        System.out.println(a);
    }

    public static void print (Integer a)
    {
        System.out.println(a);
    }
}
