package com.javarush.task.task09.task0903;

/* 
Кто меня вызывал?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
    }

    public static int method1() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        method2();
        return  trace[2].getLineNumber();
    }

    public static int method2() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        method3();
        return  trace[2].getLineNumber();
    }

    public static int method3() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        method4();
        return  trace[2].getLineNumber();
    }

    public static int method4() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        method5();
        return  trace[2].getLineNumber();
    }

    public static int method5() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        return  trace[2].getLineNumber();
    }
}
