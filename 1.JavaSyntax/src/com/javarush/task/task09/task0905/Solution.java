package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
    }

    public static int getStackTraceDeep() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        System.out.println(trace.length);
        return trace.length;
        //напишите тут ваш код
    }
}

