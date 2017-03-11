package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        System.out.println(trace[2].getClassName()+": "+trace[2].getMethodName()+": "+s);
    }
}
