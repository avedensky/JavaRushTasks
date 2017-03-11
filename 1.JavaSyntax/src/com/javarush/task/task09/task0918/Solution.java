package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends RuntimeException {

    }

    static class MyException2 extends RuntimeException {
    }

    static class MyException3 extends Exception{
    }

    static class MyException4 extends Exception{
    }
}

